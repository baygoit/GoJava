package com.gojava6.airbnb.service.implrepository;

import com.gojava6.airbnb.service.UserServiceInterface;
import com.gojava6.airbnb.user.User;

import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public class UserService implements UserServiceInterface {
    @Override
    public void create(User user) {

    }

    @Override
    public User retrieve(int userID) {
        return null;
    }

    @Override
    public List<User> retrieveAllHost() {
        return null;
    }

    @Override
    public List<User> retrieveAllRenters() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int userID) {

    }
}
