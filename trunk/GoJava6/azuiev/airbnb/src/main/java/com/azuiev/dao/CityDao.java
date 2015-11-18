package com.azuiev.dao;

import com.azuiev.model.City;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public class CityDao implements ModelDao<City>  {
    static ModelDao dao = new BasicModelDao<City>(City.class);

    @Override
    public List<City> getAll() throws SQLException {
        return (List<City>) dao.getAll();
    }

    @Override
    public City getById(Long id) throws SQLException {
        City city = (City) dao.getById(id);
        return city;
    }

    @Override
    public void update(City city) {

    }

    @Override
    public void add(City city) {

    }

    @Override
    public void delete(City city) {

    }
}
