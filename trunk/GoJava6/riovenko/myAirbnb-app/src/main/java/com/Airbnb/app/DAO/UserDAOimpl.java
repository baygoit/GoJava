package com.Airbnb.app.DAO;

import com.Airbnb.app.Maps;
import com.Airbnb.app.model.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public class UserDAOimpl implements UserDAO{

    public void registerClient(User user) {
        Maps.clients.put(user.getId(),user);
    }

    public void registerHost(User user) {
        Maps.hosts.put(user.getId(),user);
    }

    public void deleteClient(int id) {
        Maps.clients.remove(id);
    }

    public void deleteHost(int id) {
        Maps.hosts.remove(id);
    }

    public User getClient(int id) {
        return Maps.clients.get(id);
    }

    public User getHost(int id) {

        return Maps.hosts.get(id);
    }

    public List<User> getAllClients() {
        return new LinkedList<User> (Maps.clients.values());
    }

    public List<User> getAllHosts() {
        return null;
    }
}
