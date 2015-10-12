package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void save(User user) throws SQLException;
    void delete(int id) throws SQLException;
    void update(int id, User user) throws SQLException;
    User getUserById(int id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    List<User> getAllClients() throws SQLException;
    List<User> getAllHosts() throws SQLException;
}
