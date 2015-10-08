package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.SortOfDataBase;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private static final String saveUserQuery =
            "INSERT INTO user VALUES(null,?,?,?)";

    @Override
    public void saveClient(User user) {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(saveUserQuery);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getEmail());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

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
    public List<User> getAllClients() {
        return new LinkedList<>(SortOfDataBase.clients.values());
    }

    @Override
    public List<User> getAllHosts() {
        return new LinkedList<>(SortOfDataBase.hosts.values());
    }
}
