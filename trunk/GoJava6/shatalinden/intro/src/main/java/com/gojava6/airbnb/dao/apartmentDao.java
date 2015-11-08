package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.apartment.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDao {

    public static List<Apartment> pullApartmentsByCity(String city) {
        List<Apartment> apartmentsByCity = new ArrayList<>();
        try (Connection connection = DbDao.initConnection()) {
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

    public static List<Apartment> pullApartmentsByUserID(int id) {
        List<Apartment> apartmentsByCity = new ArrayList<>();
        try (Connection connection = DbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM apartments WHERE userID = ?");
            ps.setInt(1, id);
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

    public static void pushApartment(Apartment apartment) {
        try (Connection connection = DbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO apartments VALUES(?,?,?,?,?,?)");
            ps.setInt(1, apartment.getApartmentID());
            ps.setString(2, apartment.getCity());
            ps.setString(3, apartment.getType().toLowerCase());
            ps.setInt(4, apartment.getUserID());
            ps.setInt(5, apartment.getPrice());
            ps.setString(6, apartment.getShortDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}