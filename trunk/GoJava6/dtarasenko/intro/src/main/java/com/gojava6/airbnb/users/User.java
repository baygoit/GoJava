package com.gojava6.airbnb.users;

public abstract class User {

    private static int userIdCounter;
    private int userId;
    private String name;
    private String surName;
    private String email;

    public User() {
        userIdCounter += 1;
        this.userId =  userIdCounter;
    }

    public int getUserId() {
        return userId;
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

    public void setEmail(String email) {
        this.email = email;
    }
}
