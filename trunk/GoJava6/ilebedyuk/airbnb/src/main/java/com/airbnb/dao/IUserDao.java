package com.airbnb.dao;

import com.airbnb.model.User;

import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public interface IUserDao {
    List<User> getUserList();
    User getUser(int id);
    void updateName(int id, String newName);
    void updateUserType(int id);
    void delete(int id);
    void addToDb(User user);
}
