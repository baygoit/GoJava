package com.Airbnb.app.DAO;

import com.Airbnb.app.jdbc.DBConnection;
import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Apartment;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by romanroma on 10.10.15.
 */
public class ReservationDAOImpl implements ReservationDAO {
    ApartmentDAO apartmentDAO = new ApartmentDAOimpl();
    private ArrayList<Integer> apartmentsList = new ArrayList<>();
    private java.sql.Date dateF;
    private java.sql.Date dateT;

    /*private String addReservationQuery = "INSERT INTO reservation (apartmentId, userId, dateFrom, dateTo) JOIN " +
            "apartment ON (reservation.apartmentId = apartment.idApartment) JOIN user ON " +
            "(reservation.userId = user.idUser) VALUES (?,?,?,?)";*/
    private String addReservationQuery = "INSERT INTO reservation (apartmentId, userId, dateFrom, dateTo) " +
        " VALUES (?,?,?,?)";
    private String getPossibleApartmentQuery = "SELECT apt.idApartment, apt.apartmentTypeId,  FROM apt apartment " +
            "LEFT JOIN reservation ON (apt.idApartment = reservation.apartmentId) WHERE" +
            " idApartment = ? and apartmentTypeId = ? and dateFrom = ? and dateTo = ?";

    public void makeReservation (int apartmentId,Date dateFrom, Date dateTo) throws SQLException{
        dateF = new java.sql.Date(dateFrom.getTime());
        dateT = new java.sql.Date(dateTo.getTime());
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(addReservationQuery);
            psttmnt.setInt (1, apartmentId);
            psttmnt.setInt (2, 3);
            psttmnt.setDate(3, dateF);
            psttmnt.setDate(4, dateT);
            psttmnt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> searchPossibleReservations (String city, ApartType apartType,Date dateFrom, Date dateTo) throws SQLException{
        dateF = new java.sql.Date(dateFrom.getTime());
        dateT = new java.sql.Date(dateTo.getTime());
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement psttmnt = connection.prepareStatement(getPossibleApartmentQuery);
            psttmnt.setInt(1, apartmentDAO.getCityId(city));
            psttmnt.setInt(2, apartmentDAO.getApartmentTypeId(apartType));
            psttmnt.setDate(3, dateF);
            psttmnt.setDate(4, dateT);

            ResultSet result = psttmnt.executeQuery();
            while (result.next()){
                apartmentsList.add(result.getInt(1));
            }
            return apartmentsList;
        }
    }
}
