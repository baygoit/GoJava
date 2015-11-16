package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.City;

import java.util.List;

public interface CityDao {
    void save(City city);
    City get(Integer id);
    boolean update(City city);
    boolean delete(Integer id);
    List<City> getAll();
    City getByName(String name);
}
