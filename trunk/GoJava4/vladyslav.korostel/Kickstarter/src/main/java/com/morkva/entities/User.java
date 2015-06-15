package com.morkva.entities;

import com.morkva.model.dao.Identified;
import com.morkva.utils.UserType;

/**
 * Created by vladyslav on 28.05.15.
 */
public class User implements Identified<Integer> {
    private Integer id;
    private String username;
    private String password;
    private UserType userType;

    public User() {
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

    @Override
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }
}
