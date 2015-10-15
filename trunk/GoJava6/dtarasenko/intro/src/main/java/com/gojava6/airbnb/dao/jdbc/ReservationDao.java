package com.gojava6.airbnb.dao.jdbc;

import com.gojava6.airbnb.dao.IReservationDao;
import com.gojava6.airbnb.model.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationDao extends AbstractDao implements IReservationDao {

    public void createReservation(Reservation reservation) {
        String sqlCode = "INSERT INTO reservation VALUES (null, " +
                reservation.getApartmentId() + ", " +
                reservation.getUserId() + ", " +
                reservation.getStart() + ", " +
                reservation.getEnd() + ")";
        updateDatabase(sqlCode);
    }

    public void updateReservation(Reservation reservation) {
        String sqlCode = "UPDATE reservation SET start = " +
                reservation.getStart() + ", end = " +
                reservation.getEnd() + " WHERE reservation_id = " +
                reservation.getReservationId();
        updateDatabase(sqlCode);
    }

    public void deleteReservation(Reservation reservation) {
        String sqlCode = "DELETE FROM reservation WHERE reservation_id = " +
                reservation.getReservationId();
        updateDatabase(sqlCode);
    }

    public List<Reservation> getReservationList() {
        String sqlCode = "SELECT * FROM reservation";
        return (List<Reservation>)(List<?>) readDatabase(sqlCode);
    }

    public List<Reservation> getApartmentReservationList(Integer apartment_Id) {
        String sqlCode = "SELECT * FROM reservation WHERE apartment_id = " + apartment_Id;
        return (List<Reservation>)(List<?>) readDatabase(sqlCode);
    }

    public Reservation getReservation(Integer reservationId) {
        String sqlCode = "SELECT * FROM reservation WHERE reservation_id =" + reservationId;
        List<Reservation> reservationList = (List<Reservation>)(List<?>) readDatabase(sqlCode);
        return reservationList.get(0);
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
