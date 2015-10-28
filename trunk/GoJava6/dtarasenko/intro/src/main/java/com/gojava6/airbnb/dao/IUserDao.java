package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.User;

import java.util.List;

public interface IUserDao {

    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getUserList();
    User getUser(Integer userId);

}
