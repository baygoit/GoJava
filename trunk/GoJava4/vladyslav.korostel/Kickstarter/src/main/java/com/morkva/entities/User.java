package com.morkva.entities;

import com.morkva.utils.UserType;

/**
 * Created by vladyslav on 28.05.15.
 */
public class User extends Entity {
    private String username;
    private String password;
    private UserType userType;

    public User(int id) {
        super(id);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
