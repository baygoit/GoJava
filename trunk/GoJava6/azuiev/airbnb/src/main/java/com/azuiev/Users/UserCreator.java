package com.azuiev.Users;
import com.azuiev.App;
import com.azuiev.Validator;

/**
 * Created by Masta on 27.09.2015.
 */
public class UserCreator {
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

        Validator v = Validator.getInstance();

        if (!v.validateUser(user)) {
            App.log.error("failed to create - " + user);
            return false;
        } else {
            App.log.info("created - " + user);
            return true;
        }
    }
}
