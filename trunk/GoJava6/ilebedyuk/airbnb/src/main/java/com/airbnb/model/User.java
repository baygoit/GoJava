package com.airbnb.model;

import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * Created by Игорь on 20.09.2015.
 */
@Entity
@Table(name="user")
public class User implements com.airbnb.observer.Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iduser")
    private int userId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column(name = "usertype", insertable = false)
    private String userType;
    @Column
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                ", userType='" + userType + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    private static final Logger log = Logger.getLogger(User.class);

    public User() {}

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(String name, String surname, String email, String password, String userType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(String news) {
        System.out.println("Hello! " + name + ", today next news: " + news);
    }

}