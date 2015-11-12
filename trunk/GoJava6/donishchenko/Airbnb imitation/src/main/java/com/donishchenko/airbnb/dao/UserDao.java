package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User get(Integer id);
    boolean update(User user);
    boolean delete(Integer id);
    User getByLoginPassword(String login, String password);
    List<User> getAllUsers();
    List<User> getAllClients();
    List<User> getAllHosts();
}
