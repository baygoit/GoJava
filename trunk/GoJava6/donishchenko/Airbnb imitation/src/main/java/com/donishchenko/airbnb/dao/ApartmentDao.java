package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.User;

import java.util.List;

public interface ApartmentDao {
    public void save(Apartment apartment);
    public void delete(int id);
    public Apartment getById(int id);
    public List<Apartment> getAll();
    public List<Apartment> getByCity(String city);
    public List<Apartment> getAllByUser(int id);
    public List<Apartment> getAllByUser(User user);
}
