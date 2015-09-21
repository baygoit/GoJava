package com.donishchenko.airbnb.model;

import com.donishchenko.airbnb.common.Observer;
import com.donishchenko.airbnb.validation.Validator;

public abstract class User implements Observer {
    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email) {
        this.name = name.trim();
        this.surname = surname.trim();
        this.email = email.trim();
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
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
