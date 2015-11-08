package com.gojava6.airbnb.model;

import com.gojava6.airbnb.observer.Observer;

public class User implements Observer {

    private int userId;
    private String name;
    private String surname;
    private String email;
    private String userType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public void update(String loyaltyProgramName) {
        System.out.println(getName() + ", " + loyaltyProgramName + " is available for you!");
    }

    @Override
    public String toString() {
        return "User{" +
                "userType=" + userType +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
