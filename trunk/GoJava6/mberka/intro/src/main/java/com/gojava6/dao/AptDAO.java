package com.gojava6.dao;

import com.gojava6.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AptDAO {
    public void addNewApt(User user, String aptCity, Enum aptType) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String addNewApt = "insert into airbnb.apatrments (cityName, aptType) values (?, ?)";

        try {
            statement =
                    DBConnection.prepareStatement(addNewApt);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getUserCity());

            try {
                statement.executeUpdate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            /*if (!userAlreadyExists(user)) {
                try {
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    throw new Exception("UserAlreadyExistsException");
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

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

    public void addNewApartment(int idUser, String aptCity, String aptType, Date startDate, Date endDate) {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        PreparedStatement statement = null;
        String addNewApt = "insert into airbnb.apartments " +
                "(idUser, aptCity, aptType, startDate, endDate) values " +
                "(?, ?, ?, ?, ?)";

        try {
            statement =
                    DBConnection.prepareStatement(addNewApt);
            statement.setInt(1, idUser);
            statement.setString(2, aptCity);
            statement.setString(3, aptType);
            statement.setDate(4, (java.sql.Date) startDate);
            statement.setDate(5, (java.sql.Date) endDate);

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

    public List<List<String>> getAllApartments() {
        Connection DBConnection = DatabaseMySQL.getDbInstance().getConnection();
        Statement statement = null;
        String getAllUsers = "select * from airbnb.apartments";
        List<List<String>> allApts = new ArrayList<>();

        //List<String> allApts = new ArrayList<>();
        List<String> apartment = new ArrayList<>();
        allApts.add(apartment);

        try {
            statement = DBConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsers);
            SimpleDateFormat dateFormat = new SimpleDateFormat();

            while (resultSet.next()) {
                Integer idApt = resultSet.getInt("idapartments");
                Integer idUser = resultSet.getInt("idUser");
                Integer idReserv = resultSet.getInt("idreservations");
                String aptCity = resultSet.getString("aptCity");
                String aptType = resultSet.getString("aptType");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                apartment.add(String.valueOf(idApt));
                apartment.add(String.valueOf(idUser));
                apartment.add(String.valueOf(idReserv));
                apartment.add(aptCity);
                apartment.add(aptType);
                apartment.add(String.valueOf(startDate));
                apartment.add(String.valueOf(endDate));

                //allApts.add(String.valueOf(apartment));
                //System.out.println(allApts);
                /*System.out.println("IDApt: " + idApt +
                        ", idUser: " + idUser +
                        ", idReserv: " + idReserv +
                        ", aptCity: " + aptCity +
                        ", aptType: " + aptType +
                        ", Start Date: " + startDate +
                        ", End Date: " + endDate);*/
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
        return allApts;
    }

}
