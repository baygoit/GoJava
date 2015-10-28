package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.apartment.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class apartmentDao {
    public static List<Apartment> pullApartmentsByCity(String city) {
        List<Apartment> apartmentsByCity = new ArrayList<>();
        try (Connection connection = dbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM apartments WHERE city = ?");
            ps.setString(1, city);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                apartmentsByCity.add(createApartment(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartmentsByCity;
    }

    private static Apartment createApartment(ResultSet resultSet)  throws SQLException{
        Apartment apartment = new Apartment(resultSet.getString(3), resultSet.getString(2), resultSet.getInt(1), resultSet.getInt(4));
        apartment.setPrice(resultSet.getInt(5));
        apartment.setShortDescription(resultSet.getString(6));
        return apartment;
    }

//    public static void main(String[] args) {
//        List<Apartment> list = pullApartmentsByCity("London");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getShortDescription());
//        }
//    }
}