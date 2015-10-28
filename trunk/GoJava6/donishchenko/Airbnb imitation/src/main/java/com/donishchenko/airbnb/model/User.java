package com.donishchenko.airbnb.model;

import com.donishchenko.airbnb.common.Observer;
import com.donishchenko.airbnb.validation.Validator;
import com.google.common.base.Joiner;

public class User implements Observer {
    private int id;
    private String name;
    private String surname;
    private String email;
    private boolean isHost;

    public User() {}

    public User(String name, String surname, String email) {
        this.name = name.trim();
        this.surname = surname.trim();
        this.email = email.trim();
        this.isHost = false;
    }

    public User(String name, String surname, String email, boolean isHost) {
        this(name, surname, email);
        this.isHost = isHost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean host) {
        this.isHost = host;
    }

    public boolean validate() {
        return Validator.validateName(name) &&
                Validator.validateSurname(surname) &&
                Validator.validateEmail(email);
    }

    @Override
    public void update(String message) {
        System.out.println(toString() + ": " + message);
    }

    @Override
    public String toString() {
        return Joiner.on("").join(
                "User{id='", id, "', name='", name, "', surname='", surname, "', email='", email,
                "', isHost='", isHost, "'}");
    }
}
