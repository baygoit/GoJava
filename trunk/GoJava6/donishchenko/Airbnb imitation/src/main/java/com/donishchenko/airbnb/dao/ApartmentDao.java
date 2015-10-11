package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.User;

import java.util.List;

public interface ApartmentDao {
    void save(Apartment apartment);
    void delete(int id);
    Apartment getById(int id);
    List<Apartment> getAll();
    List<Apartment> getByCity(String city);
    List<Apartment> getAllByUser(int id);
    List<Apartment> getAllByUser(User user);
}
