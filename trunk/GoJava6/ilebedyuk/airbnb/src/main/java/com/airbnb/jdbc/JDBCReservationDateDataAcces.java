package com.airbnb.jdbc;

import com.airbnb.dao.IReservationDao;
import com.airbnb.model.Apartment;
import com.airbnb.model.ReservationDate;
import com.airbnb.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public class JDBCReservationDateDataAcces extends AbstractBaseDao implements IReservationDao {
    private String sqlCode = null;

    @Override
    public List<ReservationDate> getReservationDateList() {
        List<ReservationDate> reservationDates = new ArrayList<ReservationDate>();
        sqlCode = "select * from reservationdates;";
        List<Object> objects = objectsList(sqlCode);
        for (Object o : objects) {
            ReservationDate reservationDate = (ReservationDate) o;
            reservationDates.add(reservationDate);
        }
        return reservationDates;
    }

    @Override
    public ReservationDate getReservationDate(int id) {
        sqlCode = "select * from reservationdates where idreservationDates = " + id + ";";
        ReservationDate reservationDate = (ReservationDate) objectsList(sqlCode).get(0);
        System.out.println(reservationDate);
        return reservationDate;
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete from reservationdates where idreservationDates = " + id + ";";
        updateData(sqlCode);
        System.out.println("ReservationDate with id = " + id + "is deleted from DB");
    }

    @Override
    public void addToDb(ReservationDate reservationDate) {
        sqlCode = "insert into reservationdates values(null, '" +
                reservationDate.getDateBegin() + "', '" +
                reservationDate.getDateEnd() + "', '" +
                reservationDate.getApartamentId() + "');";
        updateData(sqlCode);
        System.out.println("Reservation date is added to DB");
    }

    @Override
    ReservationDate createObject(ResultSet resultSet) {
        ReservationDate reservationDate = null;
        try {
            int reservationId = resultSet.getInt("idreservationDates");
            long startReservation = resultSet.getLong("startReservation");
            long endReservation = resultSet.getLong("endReservation");
            int apartmentId = resultSet.getInt("apartmentId");

            reservationDate = new ReservationDate(startReservation, endReservation, apartmentId);
            reservationDate.setReservationDateId(reservationId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservationDate;
    }
}
