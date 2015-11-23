package com.gojava6.airbnb.dao.reservedapartment;

import com.gojava6.airbnb.Exception.daoexception.MySqlReservedApartmentDAOException;
import com.gojava6.airbnb.apartment.ReservedApartment;
import com.gojava6.airbnb.dao.daofactory.MySqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySqlReservedApartmentDAO implements ReservedApartmentDAO {


    //todo in this method created two connections. Or should i put in arguments of isReserved() connection?
    @Override
    public void create(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) throws MySqlReservedApartmentDAOException {


        if (!isReserved(apartmentID, checkIN, checkOUT)) {
            String query = "INSERT INTO airbnb.reservebook (apartmentID, hostID, renterID, checkIN, checkOUT)" +
                    " VALUES (?, ?, ?, ?, ?);";

            try (Connection connection = getConnection()) {
                PreparedStatement pstm = connection.prepareStatement(query);
                pstm.setInt(1, apartmentID);
                pstm.setInt(2, hostID);
                pstm.setInt(3, renterID);
                pstm.setDate(4, convertToSqlDate(checkIN));
                pstm.setDate(5, convertToSqlDate(checkOUT));
                pstm.executeUpdate();
                System.out.println("Reservation successful complete!");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new MySqlReservedApartmentDAOException("Cannot create reserveBook.", e);
            }
        } else {
            System.out.println("Sorry, apartment is already reserved on this date!");
        }
    }

    @Override
    public ReservedApartment retrieveApartmentByID(int apartmentID) throws MySqlReservedApartmentDAOException {  //todo listom
        String query = "SELECT * FROM airbnb.reservebook WHERE apartmentID = ?;";
        ReservedApartment reservedApartment = null;

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, apartmentID);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int apartment_ID = rs.getInt("apartmentID");
                int hostID = rs.getInt("hostID");
                int renterID = rs.getInt("renterID");
                Date checkIN = convertToJavaDate(rs.getDate("checkIN"));
                Date checkOUT = convertToJavaDate(rs.getDate("checkOUT"));

                return new ReservedApartment(apartment_ID, hostID, renterID, checkIN, checkOUT);
            }
            return reservedApartment;
        } catch (SQLException | MySqlReservedApartmentDAOException e) {
            e.printStackTrace();
            throw new MySqlReservedApartmentDAOException("Cannot retrieve list of reserveBook.", e);
        }
    }

    @Override
    public List<ReservedApartment> retrieveAoartmentsByHostID(int hostID) throws MySqlReservedApartmentDAOException {
        String query = "SELECT * FROM airbnb.reservebook WHERE hostID = ?;";
        List<ReservedApartment> resultList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, hostID);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int aparmentID = rs.getInt("apartmentID");
                int host_ID = rs.getInt("hostID");
                int renterID = rs.getInt("renterID");
                Date checkIN = convertToJavaDate(rs.getDate("checkIN"));
                Date checkOUT = convertToJavaDate(rs.getDate("checkOUT"));

                resultList.add(new ReservedApartment(aparmentID, host_ID, renterID, checkIN, checkOUT));
            }
            return resultList;
        } catch (SQLException | MySqlReservedApartmentDAOException e) {
            e.printStackTrace();
            throw new MySqlReservedApartmentDAOException("Cannot retrieve list of reserveBook by hostID.", e);
        }
    }

    @Override
    public void update(int apartmentID, int hostID, int renterID,
                       Date oldCheckIN, Date oldCheckOUT, Date newCheckIN, Date newCheckOUT) {
        String query = "UPDATE airbnb.reservebook " +
                "SET hostID = ?, renterID = ?, checkIN = ?, checkOUT = ? " +
                "WHERE apartmentID = ? AND (checkIN = ? AND checkOUT = ?);";

        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, hostID);
            pstm.setInt(2, renterID);
            pstm.setDate(3, convertToSqlDate(newCheckIN));
            pstm.setDate(4, convertToSqlDate(newCheckOUT));
            pstm.setInt(5, apartmentID);
            pstm.setDate(6, convertToSqlDate(oldCheckIN));
            pstm.setDate(7, convertToSqlDate(oldCheckOUT));
            pstm.executeUpdate();
        } catch (SQLException | MySqlReservedApartmentDAOException e) {
            e.printStackTrace();
            throw new MySqlReservedApartmentDAOException("Cannot update reserve apartment.", e);
        }
    }

    @Override
    public void delete(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) throws MySqlReservedApartmentDAOException {
        String query = "DELETE FROM airbnb.reservebook " +
                "WHERE (apartmentID = ? AND hostID = ?) AND (checkIN = ? AND checkOUT = ?);"; //todo also check renter?
        try (Connection connection = getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, apartmentID);
            pstm.setInt(2, hostID);
            pstm.setDate(3, convertToSqlDate(checkIN));
            pstm.setDate(4, convertToSqlDate(checkOUT));
            pstm.executeUpdate();
        } catch (SQLException | MySqlReservedApartmentDAOException e) {
            e.printStackTrace();
            throw new MySqlReservedApartmentDAOException("Cannot delete reserve from database.", e);
        }
    }

    @Override
    public boolean isReserved(int apartmentID, Date checkIN, Date checkOUT) throws MySqlReservedApartmentDAOException {

        String query = "select reservebook.is_reserved from airbnb.reservebook where apartmentID = ? and " +
                "((checkIN between ? and ?) or (checkOUT between ? and ?));";

        try (Connection connection = getConnection()) {

            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, apartmentID);
            pstm.setDate(2, convertToSqlDate(checkIN));
            pstm.setDate(3, convertToSqlDate(checkOUT));
            pstm.setDate(4, convertToSqlDate(checkIN));
            pstm.setDate(5, convertToSqlDate(checkOUT));

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                boolean isReserved = rs.getBoolean("is_reserved");

                if (isReserved) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MySqlReservedApartmentDAOException("Cannot check if apartment is reserved.", e);
        }
        return false;
    }

    private Connection getConnection() throws MySqlReservedApartmentDAOException {

        try {
            return new MySqlDAOFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MySqlReservedApartmentDAOException("Cannot create connection.", e);
        }
    }

    private java.sql.Date convertToSqlDate(java.util.Date date) throws MySqlReservedApartmentDAOException {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        }
        throw new MySqlReservedApartmentDAOException("Cannot convert java date to sql date.");
    }

    private java.util.Date convertToJavaDate(java.sql.Date date) throws MySqlReservedApartmentDAOException {
        if (date != null) {
            return new java.util.Date(date.getTime());
        }
        throw new MySqlReservedApartmentDAOException("Cannot convert SQL date to java Date.");
    }
}
