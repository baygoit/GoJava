package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Apartment;

import java.util.List;

public interface ApartmentDao {
    void save(Apartment apartment);
    Apartment get(Integer id);
    boolean update(Apartment apartment);
    boolean delete(Integer id);
    List<Apartment> getAll();
    List<Apartment> getAllByCity(String city);
    List<Apartment> getAllByUser(Integer id);
}
