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
public class UserCreator{

    private Set<String> emails = new TreeSet<String>();
    private List<User> users = new LinkedList<User>();


    public User createUser(String name, String surName, String email) {

        User user = new User(name, surName, email);

        if (validate(user)) {
            return user;
        } else {
            return null;
        }
    }
    public User createUser(String name, String surName, String email, UserRoles... roles) {

        User user = createUser(name, surName, email);
        if (user != null){
            for (UserRoles userRoles :roles) {
                user.addRole(userRoles);
            }

        }
        return user;
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
