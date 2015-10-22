package com.Airbnb.app.DAO;

import com.Airbnb.app.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public interface UserDAO {
    public void addUser (User user) throws SQLException;
    public void deleteUser (int id) throws SQLException;
    public User getUserById (int id) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    public List<User> getAllClients()throws SQLException;
    public List<User>getAllHosts() throws SQLException;

}
