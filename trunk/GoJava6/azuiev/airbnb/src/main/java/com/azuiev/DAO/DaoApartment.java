package com.azuiev.dao;

import com.azuiev.db.AirbnbDB;
import com.azuiev.enums.ApartType;
import com.azuiev.model.Apartment;
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
public class DaoApartment implements DaoModel{
    private final Connection connection;


    public DaoApartment(Connection connection) {
        this.connection = connection;
    }
    public DaoApartment() {
        connection = new AirbnbDB().getConnection();

    }
    @Override
    public List<Apartment> getAll() throws SQLException {
        String sql = "select * from apartment;";
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        Apartment Apartment = null;
        List<Apartment> list = new ArrayList<Apartment>();


        while (rs.next()){
            list.add(new Apartment((User)rs.getObject(1),rs.getString(3),rs.getString(2), ApartType.values()[1]));
        }

        return list;
    }

    @Override
    public Apartment getById(Integer id) throws SQLException {

        String sql = "select * from apartment where id = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Apartment Apartment = null;

        while (rs.next()){
            Apartment = new Apartment((User)rs.getObject(1),rs.getString(3),rs.getString(2), ApartType.values()[1]);
        }

        return Apartment;

    }

    public List<Apartment> getByCity(Integer id) throws SQLException {
        String sql = "select apartment.id, user, city.name, address, aparttype from apartment \n" +
                "left join city on (apartment.city=city.id) where apartment.city = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        List<Apartment> list = new ArrayList<Apartment>();

        while (rs.next()){
            list.add(new Apartment(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4), ApartType.values()[rs.getInt(5)]));
        }

        return list;
    }

    @Override
    public void update(Object obj) {
        //TODO
    }

    @Override
    public void insert(Object obj) {
        //TODO
    }

    @Override
    public void delete(Object obj) {
        //TODO
    }
}
