package com.azuiev.model;

import com.azuiev.AirBnB;
import com.azuiev.enums.ApartType;
import com.azuiev.enums.UserRoles;
import com.azuiev.interfaces.Observer;
import com.azuiev.Validator;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Lera on 21.09.2015.
 */

@Entity
@Table(name = "user", catalog = "airbnb")

public class User implements Observer {
    private String name;
    private String surName;
    private String email;
    private String password;
    private Long id;

    @Transient
    private List<UserRoles> myRoles = new LinkedList<UserRoles>();

    public User() {
    }

    private User(String name, String surName, String email) {

        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    private User(String name, String surName, String email, Long id) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.id = id;
    }

    //getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public List<UserRoles> getMyRoles() {
        return myRoles;
    }

    public void setMyRoles(List<UserRoles> myRoles) {
        this.myRoles = myRoles;
    }

    //other methods
    public void notifyObserver(String s) {
        System.out.println(s);
    }

    private boolean hasRole(UserRoles role) {
        return myRoles.contains(role);
    }

    public void addRole(UserRoles role) {
        if (hasRole(role)) {
            AirBnB.log.info("User: " + this + " already has role - " + role);
            return;
        } else {
            myRoles.add(role);
            AirBnB.log.info("User: " + this + " now has new role - " + role);

        }
    }

    public Apartment registerBook(City city, String address, ApartType apartType) {
        if (hasRole(UserRoles.HOST)) {
            return new Apartment(address, apartType, city, this);
        } else {
            AirBnB.log.error("User: " + this + "has`t role " + UserRoles.HOST);
            return null;
        }

    }

    public boolean reserveApartment(Apartment apartment, Date start, Date end) {
        if (hasRole(UserRoles.CLIENT)) {
            return apartment.reserveApartment(this, start, end);
        } else {
            AirBnB.log.error("User: " + this + "has`t role " + UserRoles.CLIENT);
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("name = '%s', surName = '%s', email = '%s'", name, surName, email);
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Builder() {
        }

        private static Set<String> emails = new TreeSet<String>();
        private static List<User> users = new LinkedList<User>();

        public User createUser(String name, String surName, String email) {

            return createUser(-1, name, surName, email);

        }

        public User createUser(Long id, String name, String surName, String email) {

            User user = new User(name, surName, email, id);

            if (validate(user)) {
                return user;
            } else {
                return null;
            }
        }

        public User createUser(Integer id, String name, String surName, String email, UserRoles... roles) {

            User user = createUser(id, name, surName, email);
            if (user != null) {
                for (UserRoles userRoles : roles) {
                    user.addRole(userRoles);
                }

            }
            return user;
        }

        public User createUser(String name, String surName, String email, UserRoles... roles) {
            return createUser(-1, name, surName, email, roles);

        }

        private boolean validate(User user) {
            if (emails.contains(user.getEmail())) {
                AirBnB.log.error("Failed to create user. Email is busy - " + user.getEmail());
                return false;
            }

            Validator v = Validator.getInstance();

            if (!v.validateUser(user)) {
                AirBnB.log.error("Failed to create - " + user);
                return false;
            } else {
                AirBnB.log.info("User created - " + user);
                emails.add(user.getEmail());
                users.add(user);
                return true;
            }
        }
    }
}
