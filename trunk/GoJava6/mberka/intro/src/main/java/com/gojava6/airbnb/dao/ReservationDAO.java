package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.Reservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationDAO {

    public void makeReservation(Reservation reservation) {
        Connection connection = DatabasePostgreSQL.getDbInstance().getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO airbnb.users VALUES (?, ?, ?)");
            preparedStatement.setObject(1, reservation.getApartment());
            preparedStatement.setDate(2, (Date) reservation.getMoveInDate());
            preparedStatement.setDate(3, (Date) reservation.getMoveInDate());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reservation getReservation(String id) {

        return null;
    }

    public void updateReservation(Reservation reservation) {

    }

    public void deleteReservation(String id) {

    }
}
