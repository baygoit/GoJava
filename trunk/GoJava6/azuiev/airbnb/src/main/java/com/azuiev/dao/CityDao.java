package com.azuiev.dao;

import com.azuiev.model.City;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public class CityDao implements ModelDao  {

    @Override
    public List<City> getAll() throws SQLException {
        return null;
    }

    @Override
    public Object getById(Long id) throws SQLException {
        return null;
    }


    @Override
    public void update(Object obj) {

    }

    @Override
    public void add(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }
}
