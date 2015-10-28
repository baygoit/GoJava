package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int save(User user) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(int id, User user) throws SQLException;
    User get(int id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    List<User> getAllClients() throws SQLException;
    List<User> getAllHosts() throws SQLException;
}
