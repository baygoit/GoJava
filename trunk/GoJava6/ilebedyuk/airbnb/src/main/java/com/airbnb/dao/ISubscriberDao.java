package com.airbnb.dao;

import com.airbnb.model.User;

import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public interface ISubscriberDao {
    List<User> getUserList();
    User getUser(int id);
    void update(User user);
    void delete(User user);
    void addToDb(User user);
}
