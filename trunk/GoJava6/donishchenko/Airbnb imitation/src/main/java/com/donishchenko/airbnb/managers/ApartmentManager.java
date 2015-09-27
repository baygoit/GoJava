package com.donishchenko.airbnb.managers;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.Host;

import java.util.List;

public interface ApartmentManager {
    public void save(Apartment apartment);
    public void delete(int id);
    public Apartment getById(int id);
    public List<Apartment> getAll();
    public List<Apartment> getByCity(String city);
    public List<Apartment> getAllByHost(int id);
    public List<Apartment> getAllByHost(Host host);
}
