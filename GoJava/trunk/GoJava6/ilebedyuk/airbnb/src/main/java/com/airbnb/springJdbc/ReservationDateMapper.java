package com.airbnb.springJdbc;

import com.airbnb.model.ReservationDate;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Игорь on 29.10.2015.
 */
public class ReservationDateMapper implements RowMapper<ReservationDate> {
    public ReservationDate mapRow(ResultSet resultSet, int i) throws SQLException {
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setReservationDateId(resultSet.getInt("idreservationdates"));
        reservationDate.setDateBegin(resultSet.getLong("startReservation"));
        reservationDate.setDateEnd(resultSet.getLong("endReservation"));
        reservationDate.setApartamentId(resultSet.getInt("apartmentId"));
        return reservationDate;
    }
}
