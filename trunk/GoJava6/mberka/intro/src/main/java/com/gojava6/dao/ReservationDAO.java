package com.gojava6.dao;

import com.gojava6.model.Reservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationDAO {

    public void makeReservation(Reservation reservation) {
        Connection connection = DatabaseReservePostgreSQL.getDbInstance().getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert insert into airbnb.users values (?, ?, ?)");
            preparedStatement.setObject(1, reservation.getRoom());
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
