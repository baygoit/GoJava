package com.gojava6.observer;

public class User implements Observer {

    private String userName;
    private String userSurname;
    private String email;

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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                '}';
    }


    @Override
    public void update() {

    }
}
