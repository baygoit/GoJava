package com.gojava6.airbnb.application;

import com.gojava6.airbnb.users.User;
import com.gojava6.airbnb.users.UserValidator;

import java.util.ArrayList;
import java.util.List;

public class  Application {

    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return userList;
    }

    public void registerUser(User user) {
        UserValidator userValidator = new UserValidator(user);
        if (userValidator.isValidUser()) {
            userList.add(user);
            System.out.println("User " + user.getName() + " is registered now. User ID: " + user.getUserId());
        }
    }
}
