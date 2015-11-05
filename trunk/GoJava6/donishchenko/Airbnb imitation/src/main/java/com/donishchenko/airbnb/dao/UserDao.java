package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    Integer save(User user) throws SQLException;
    boolean delete(Integer id) throws SQLException;
    boolean update(Integer id, User user) throws SQLException;
    User get(Integer id) throws SQLException;
    User getByLoginPassword(String login, String password) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    List<User> getAllClients() throws SQLException;
    List<User> getAllHosts() throws SQLException;
}
