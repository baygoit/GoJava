package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.User;

import java.util.List;

public interface UserDao {
    public void saveClient(User user);
    public void saveHost(User user);
    public void deleteClient(int id);
    public void deleteHost(int id);
    public User getClientById(int id);
    public User getHostById(int id);
    public List<User> getAllClients();
    public List<User> getAllHosts();
}
