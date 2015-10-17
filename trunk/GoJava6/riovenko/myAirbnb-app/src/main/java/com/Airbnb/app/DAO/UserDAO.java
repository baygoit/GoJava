package com.Airbnb.app.DAO;

import com.Airbnb.app.model.User;

import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public interface UserDAO {
    public void registerClient (User user);
    public void registerHost (User user);
    public void deleteClient (int id);
    public void deleteHost (int id);
    public User getClient (int id);
    public User getHost (int id);
    public List<User> getAllClients();
    public List<User>getAllHosts();

}
