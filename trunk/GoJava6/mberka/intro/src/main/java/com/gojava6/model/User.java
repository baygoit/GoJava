package com.gojava6.model;

import com.gojava6.observer.Validation;

public class User {

    private int idUser;
    private String userName;
    private String userSurname;
    private String email;
    private String userCity;
    private boolean hostUser;

    public User() {
    }

    public User(String userName, String userSurname, String email, String userCity) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.userCity = userCity;
        this.hostUser = false;
    }

    public int getId() {
        return idUser;
    }

    public void setId(int id) {
        this.idUser = idUser;
    }

    public boolean isHostUser() {
        return hostUser;
    }

    public void setHostUser(boolean hostUser) {
        this.hostUser = hostUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (Validation.getValidation().validUserName(userName)) {
            this.userName = userName;
        }
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        if (Validation.getValidation().validUserSurname(userSurname)) {
            this.userSurname = userSurname;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Validation.getValidation().validEmail(email)) {
            this.email = email;
        }
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        if (Validation.getValidation().validCityName(userCity)) {
            this.userCity = userCity;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                '}';
    }
}
