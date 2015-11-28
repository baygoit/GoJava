package com.gojava6.airbnb.service;

import com.gojava6.airbnb.user.User;

import java.util.List;

public interface UserServiceInterface {

    void create(User user);

    User retrieve(int userID);

    List<User> retrieveAllHost();

    List<User> retrieveAllRenters();

    void update(User user);

    void delete(int userID);
}

