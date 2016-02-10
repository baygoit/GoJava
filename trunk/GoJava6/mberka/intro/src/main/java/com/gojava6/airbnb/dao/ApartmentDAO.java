package com.gojava6.airbnb.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ApartmentDAO {
    public void addNewApartment(String aptCity, Enum aptType, Date startDate, Date endDate) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String addNewApt = "insert into airbnb.apatrments (aptCity, aptType, startDate, endDate) " +
                "values (?, ?, ?, ?)";

        try {
            statement = DBConnection.prepareStatement(addNewApt);
            statement.setString(1, aptCity);
            statement.setString(2, aptType.name());
            statement.setDate(3, (java.sql.Date) startDate);
            statement.setDate(4, (java.sql.Date) endDate);

            try {
                statement.executeUpdate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getAllAptCities() {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        Statement statement = null;
        String getAllUsers = "select aptCity from airbnb.apartments";
        List<String> allCities = new ArrayList<>();

        try {
            statement = DBConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsers);

            while (resultSet.next()) {
                String aptCity = resultSet.getString("aptCity");
                allCities.add(aptCity);
                //System.out.println(allCities);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allCities;
    }

    public Map<Integer, List<String>> getAllApartments() {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        Statement statement = null;
        String getAllUsers = "select * from airbnb.apartments";
        Map<Integer, List<String>> allApartments = new HashMap<>();
        List<String> apartment = new ArrayList<>();

        try {
            statement = DBConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsers);

            while (resultSet.next()) {
                int idApartment = resultSet.getInt("idApartment");
                int idUser = resultSet.getInt("user_id");                ;
                String aptCity = resultSet.getString("apartmentTypeCity");
                String aptType = resultSet.getString("apartmentType");
                String description = resultSet.getString("description");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");

                apartment.add(aptCity);
                apartment.add(aptType);
                apartment.add(description);
                apartment.add(String.valueOf(startDate));
                apartment.add(String.valueOf(endDate));
                apartment.add(String.valueOf(idUser));
                allApartments.put(idApartment,
                        apartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allApartments;
    }
}
