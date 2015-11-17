package com.azuiev.dao;

import com.azuiev.db.AirbnbDBDao;
import com.azuiev.enums.ApartType;
import com.azuiev.model.Apartment;
import com.azuiev.model.City;
import com.azuiev.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 02.11.15.
 */
//TODO reimplement metods
public class ApartmentDao implements ModelDao {

    static ModelDao dao = new AbstractModelDao(new Apartment());

    @Override
    public List<?> getAll() throws SQLException {
        return (List<Apartment>) dao.getAll();
    }


    @Override
    public Apartment getById(Long id) throws SQLException {

        return null;

    }

    public List<Apartment> getByCity(Long id) throws SQLException {

        return null;
    }

    @Override
    public void update(Object obj) {
        //TODO
    }

    @Override
    public void add(Object obj) {
        //TODO
    }

    @Override
    public void delete(Object obj) {
        //TODO
    }
}
