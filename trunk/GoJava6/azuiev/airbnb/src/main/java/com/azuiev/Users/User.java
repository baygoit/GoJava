package com.azuiev.Users;

import com.azuiev.App;
import com.azuiev.Organization.Organization;
import com.azuiev.Validator;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Lera on 21.09.2015.
 */
public abstract class User implements Observer {
    private String name;
    private String surName;
    private String email;


    public void resiveMessage(String s){
        System.out.println(s);
    }

    public User(String name, String surName, String email) {

        this.name = name;
        this.surName = surName;
        this.email = email;


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

    @Override
    public String toString() {
        return String.format("name = '%s', surName = '%s', email = '%s'", name , surName ,email);
    }
}
