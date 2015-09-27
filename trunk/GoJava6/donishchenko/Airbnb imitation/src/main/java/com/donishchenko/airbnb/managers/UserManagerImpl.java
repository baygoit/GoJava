package com.donishchenko.airbnb.managers;

import com.donishchenko.airbnb.SortOfDataBase;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.User;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class UserManagerImpl implements UserManager {
    @Override
    public void saveClient(User user) {
        SortOfDataBase.clients.put(user.getId(), user);
    }

    @Override
    public void saveHost(User user) {
        SortOfDataBase.hosts.put(user.getId(), user);
    }

    @Override
    public void deleteClient(int id) {
        SortOfDataBase.clients.remove(id);
    }

    @Override
    public void deleteHost(int id) {
        User host = SortOfDataBase.hosts.remove(id);
        Map<Integer, Apartment> apartments = SortOfDataBase.apartments;

        for(Iterator<Map.Entry<Integer, Apartment>> it = apartments.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Apartment> entry = it.next();
            if(entry.getValue().getHost().getId() == host.getId()) {
                it.remove();
            }
        }
    }

    @Override
    public User getClientById(int id) {
        return SortOfDataBase.clients.get(id);
    }

    @Override
    public User getHostById(int id) {
        return SortOfDataBase.hosts.get(id);
    }

    @Override
    public Collection<User> getAllClients() {
        return SortOfDataBase.clients.values();
    }

    @Override
    public Collection<User> getAllHosts() {
        return SortOfDataBase.hosts.values();
    }
}
