package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ReservationDao extends AbstractDao {

    public void createReservation(int apartmentId, int userId, Date start, Date end) {
        String sqlCode = "INSERT INTO reservation VALUES (null, "
                + apartmentId + ", "
                + userId + ", "
                + start.getTime() + ", "
                + end.getTime() + ")";
        updateDatabase(sqlCode);
    }

    public void updateReservationDates(int reservation_id, Date start, Date end) {
        String sqlCode = "UPDATE reservation SET start = "
                + start.getTime() + ", end = "
                + end.getTime() + " WHERE reservation_id = "
                + reservation_id;
        updateDatabase(sqlCode);
    }

    public void deleteReservation(int reservationId) {
        String sqlCode = "DELETE FROM reservation WHERE reservation_id = " + reservationId;
        updateDatabase(sqlCode);
    }

    public List<Object> getReservationList() {
        String sqlCode = "SELECT * FROM reservation";
        return readDatabase(sqlCode);
    }

    public List<Object> getReservationListOfApartment(int apartment_Id) {
        String sqlCode = "SELECT * FROM reservation WHERE apartment_id = " + apartment_Id;
        List<Object> reservationListOfApartment = readDatabase(sqlCode);
        return reservationListOfApartment;
    }

    @Override
    Reservation createObject(ResultSet resultSet) throws SQLException {
        int reservationId = resultSet.getInt("reservation_id");
        int apartmentId = resultSet.getInt("apartment_id");
        int userId = resultSet.getInt("user_id");
        long start = resultSet.getLong("start");
        long end = resultSet.getLong("end");

        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation.setApartmentId(apartmentId);
        reservation.setUserId(userId);
        reservation.setStart(start);
        reservation.setEnd(end);

        return reservation;
    }

}
