package com.gojava6.airbnb.model;


public enum UserType {

    CLIENT ("client"),
    HOST ("host");

    private final String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

}
