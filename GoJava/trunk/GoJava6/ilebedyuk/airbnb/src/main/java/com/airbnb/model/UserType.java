package com.airbnb.model;

/**
 * Created by Игорь on 11.10.2015.
 */
public enum UserType {
    CLIENT ("Client"),
    HOST ("Host");

    private final String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
    
    
}
