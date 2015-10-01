package com.azuiev.Users;

import com.azuiev.App;
import com.azuiev.Books.ApartType;
import com.azuiev.Books.Apartment;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 21.09.2015.
 */
public class User implements Observer {
    private String name;
    private String surName;
    private String email;
    private List<UserRoles> myRoles = new LinkedList<UserRoles>();

    public User(String name, String surName, String email) {
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void notifyObserver(String s) {
        System.out.println(s);
    }

    private boolean hasRole(UserRoles role) {
        return myRoles.contains(role);
    }

    public void addRole(UserRoles role) {
        if (hasRole(role)) {
            App.log.info("User: " + this + " already has role - " + role);
            return;
        } else {
            myRoles.add(role);
            App.log.info("User: " + this + " now has new role - " + role);

        }
    }

    public Apartment registerBook(String city, String address, ApartType apartType) {
        if (hasRole(UserRoles.HOST)) {
            return Apartment.registerBook(this, city, address, apartType);
        } else {
            App.log.error("User: " + this + "has`t role " + UserRoles.HOST);
            return null;
        }

    }

    public boolean reserveApartment(Apartment apartment, Date start, Date end) {
        if (hasRole(UserRoles.CLIENT)) {
            return apartment.reserveApartment(this, start, end);
        } else {
            App.log.error("User: " + this + "has`t role " + UserRoles.CLIENT);
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("name = '%s', surName = '%s', email = '%s'", name, surName, email);
    }
}
