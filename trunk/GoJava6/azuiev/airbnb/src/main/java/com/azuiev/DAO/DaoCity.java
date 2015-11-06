package com.azuiev.dao;

import com.azuiev.db.AirbnbDB;
import com.azuiev.model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public class DaoCity implements DaoModel {

    private final Connection connection;

    public DaoCity(Connection connection) {
        this.connection = connection;
    }
    public DaoCity() {
        this.connection = new AirbnbDB().getConnection();
    }

    @Override
    public List<City> getAll() throws SQLException {
        String sql = "select city.id,city.name,cityimages.image from city left join cityimages " +
                "on (city.id = cityimages.city);";
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<City> list = new ArrayList<City>();


        while (rs.next()){
            list.add(new City(rs.getInt(1),rs.getString(2),rs.getString(3)));
        }

        return list;
    }

    @Override
    public City getById(Integer i) throws SQLException {
       //TODO
        return null;
    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void insert(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }
}
