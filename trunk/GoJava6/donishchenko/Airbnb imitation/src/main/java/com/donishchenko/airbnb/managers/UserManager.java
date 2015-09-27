package com.donishchenko.airbnb.managers;

import com.donishchenko.airbnb.model.User;

import java.util.Collection;

public interface UserManager {
    public void saveClient(User user);
    public void saveHost(User user);
    public void deleteClient(int id);
    public void deleteHost(int id);
    public User getClientById(int id);
    public User getHostById(int id);
    public Collection<User> getAllClients();
    public Collection<User> getAllHosts();
}
