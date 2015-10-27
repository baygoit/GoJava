package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Apartment;

import java.sql.SQLException;
import java.util.List;

public interface ApartmentDao {
    void save(Apartment apartment) throws SQLException;
    void delete(int id) throws SQLException;
    void update(int id, Apartment apartment) throws SQLException;
    Apartment get(int id) throws SQLException;
    List<Apartment> getAll() throws SQLException;
    List<Apartment> getAllByCity(String city) throws SQLException;
    List<Apartment> getAllByUser(int id) throws SQLException;
}
