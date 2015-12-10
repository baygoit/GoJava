package com.gojava6.airbnb.dao.apartmentdao;

import com.gojava6.airbnb.Exception.daoexception.MySqlApartmentDaoException;
import com.gojava6.airbnb.Exception.typeException.CityTypeException;
import com.gojava6.airbnb.model.apartment.*;
import com.gojava6.airbnb.dao.daofactory.MySqlDAOFactory;

import com.gojava6.airbnb.Exception.daoexception.MySqlApartmentDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlApartmentDao implements ApartmentDAO {

    @Override
    public boolean create(Apartment apartment) {

        String query = "Insert into airbnb.apartment " +
                "(hostID, apartmentType, city, address, rooms, accommodates, squareFootage) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = getConnection()){
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, apartment.getHostID());
            pstm.setString(2, String.valueOf(apartment.getApartmentType()));
            pstm.setString(3, String.valueOf(apartment.getCity()));
            pstm.setString(4, apartment.getAddress());
            pstm.setInt(5, apartment.getRooms());
            pstm.setInt(6, apartment.getAccommodates());
            pstm.setInt(7, apartment.getSquareFootage());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MySqlApartmentDaoException("Can`t create apartment in DB.", e);
        }
    }

    @Override
    public Apartment retrieveByID(int apartmentID) throws MySqlApartmentDaoException {
        String query = "SELECT * FROM airbnb.apartment WHERE apartmentID = ?;";
        Apartment apartment;

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, apartmentID);

            ResultSet rs = pstm.executeQuery();
            rs.next();

            int hostID = rs.getInt("hostID");
            ApartmentType apartmentType = ApartmentType.valueOf(rs.getString("apartmentType"));
            CityType cityType = CityType.fromValue(rs.getString("city"));
            String address = rs.getString("address");
            int rooms = rs.getInt("rooms");
            int accommodates = rs.getInt("accommodates");
            int squareFootage = rs.getInt("squareFootage");

            apartment = new Apartment(apartmentType, cityType, "some street 4", 2);
            apartment.setApartmentID(apartmentID);
            apartment.setHostID(hostID);
            apartment.setAddress(address);
            apartment.setRooms(rooms);
            apartment.setAccommodates(accommodates);
            apartment.setSquareFootage(squareFootage);

        } catch (SQLException | CityTypeException e) {
            e.printStackTrace();
            throw new MySqlApartmentDaoException("Can`t retrieveApartmentByID apartment by id.", e);
        }
        return apartment;
    }

    @Override
    public List<Apartment> retrieveAllByCity(CityType city) throws MySqlApartmentDaoException {
        String query = "SELECT * FROM airbnb.apartment WHERE city = ?;";
        PreparedStatement pstm;
        ResultSet rs;
        List<Apartment> resultList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, String.valueOf(city));

            rs = pstm.executeQuery();

            while (rs.next()) {
                int apartmentID = rs.getInt("apartmentID");
                int hostID = rs.getInt("hostID");
                ApartmentType apartmentType = ApartmentType.valueOf(rs.getString("apartmentType"));
                CityType cityType = CityType.fromValue(rs.getString("city"));
                String address = rs.getString("address");
                int rooms = rs.getInt("rooms");
                int accommodates = rs.getInt("accommodates");
                int sqft = rs.getInt("squareFootage");
                Apartment apartm = new Apartment(apartmentID, hostID, apartmentType,
                        cityType, address, rooms, accommodates, sqft);
                resultList.add(apartm);
            }
        } catch (SQLException | CityTypeException e) {
            e.printStackTrace();
            throw new MySqlApartmentDaoException("Can`t retrieve apartment by city.", e);
        }
        return resultList;
    }

    @Override
    public List<Apartment> retrieveAllByHost(int hostID) throws MySqlApartmentDaoException {
        String query = "SELECT * FROM airbnb.apartment WHERE hostID = ?;";
        PreparedStatement pstm;
        ResultSet rs;
        List<Apartment> resultList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, hostID);

            rs = pstm.executeQuery();

            while (rs.next()) {
                int apartmentID = rs.getInt("apartmentID");
                ApartmentType apartmentType = ApartmentType.valueOf(rs.getString("apartmentType"));
                CityType cityType = CityType.fromValue(rs.getString("city"));
                String address = rs.getString("address");
                int rooms = rs.getInt("rooms");
                int accommodates = rs.getInt("accommodates");
                int sqft = rs.getInt("squareFootage");
                Apartment apartm = new Apartment(apartmentID, hostID, apartmentType,
                        cityType, address, rooms, accommodates, sqft);
                resultList.add(apartm);
            }
        } catch (SQLException | CityTypeException e) {
            e.printStackTrace();
            throw new MySqlApartmentDaoException("Can`t retrieveApartmentByID apartments by host.", e);
        }
        return resultList;
    }

    @Override
    public boolean update(Apartment apartment) throws MySqlApartmentDaoException {
        String query = "UPDATE `airbnb`.`apartment` SET `hostID`= ?, `apartmentType`= ?, " +
                "`city`= ?, `address`= ?, `rooms`= ?, `accommodates`= ?, `squareFootage`= ? " +
                "WHERE `apartmentID`= ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, apartment.getHostID());
            pstm.setString(2, String.valueOf(apartment.getApartmentType()));
            pstm.setString(3, String.valueOf(apartment.getCity()));
            pstm.setString(4, apartment.getAddress());
            pstm.setInt(5, apartment.getRooms());
            pstm.setInt(6, apartment.getAccommodates());
            pstm.setInt(7, apartment.getSquareFootage());
            pstm.setInt(8, apartment.getApartmentID());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MySqlApartmentDaoException("Can`t update apartment in database.", e);
        }
    }

    @Override
    public boolean delete(int apartmentID) throws MySqlApartmentDaoException {
        String query = "DELETE FROM airbnb.apartment WHERE apartmentID = ?;";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, apartmentID);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MySqlApartmentDaoException("Can`t delete apartment from database.", e);
        }
    }

    private Connection getConnection() throws SQLException {
        try {
            return new MySqlDAOFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("No connection with MySQL database.", e);
        }
    }
}
