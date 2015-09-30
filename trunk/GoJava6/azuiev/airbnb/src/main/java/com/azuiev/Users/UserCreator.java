package com.azuiev.Users;
import com.azuiev.App;
import com.azuiev.Validator;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Masta on 27.09.2015.
 */
public class UserCreator {

    private Set<String> emails = new TreeSet<String>();
    private List<User> users = new LinkedList<User>();


    public Host createHost(String name, String surName, String email) {

        Host host = new Host(name, surName, email);
        if (validate(host)) {
            return host;
        } else {
            return null;
        }
    }

    public Client createClient(String name, String surName, String email) {

        Client client = new Client(name, surName, email);
        if (validate(client)) {
            return client;
        } else {
            return null;
        }
    }

    public User createUser(User user) {

        if (validate(user)) {
            return user;
        } else {
            return null;
        }

    }

    private boolean validate(User user) {
        if (emails.contains(user.getEmail())){
            App.log.error("Failed to create user. Email is busy - " + user.getEmail());
            return false;
        }

        Validator v = Validator.getInstance();

        if (!v.validateUser(user)) {
            App.log.error("Failed to create - " + user);
            return false;
        } else {
            App.log.info("User created - " + user);
            emails.add(user.getEmail());
            users.add(user);
            return true;
        }
    }
}
