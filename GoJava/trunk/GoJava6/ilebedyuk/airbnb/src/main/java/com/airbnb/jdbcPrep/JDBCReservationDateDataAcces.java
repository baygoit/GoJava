package com.airbnb.jdbcPrep;

import com.airbnb.dao.IReservationDao;
import com.airbnb.jdbcPrep.AbstractBaseDao;
import com.airbnb.model.ReservationDate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            List<Object> objects = objectsList();
            for (Object o : objects) {
                ReservationDate reservationDate = (ReservationDate) o;
                reservationDates.add(reservationDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reservationDates;
    }

        @Override
    public List<ReservationDate> getReservationDateListByIdApartament(int idApartament) {
        List<ReservationDate> reservationDates = new ArrayList<ReservationDate>();
        sqlCode = "SELECT reservationdates.* FROM reservationdates join apartaments on apartaments.idapartaments = reservationdates.apartmentId where apartaments.idapartaments = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, idApartament);
            List<Object> objects = objectsList();
            for (Object o : objects) {
                ReservationDate reservationDate = (ReservationDate) o;
                reservationDates.add(reservationDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reservationDates;
    }

    @Override
    public ReservationDate getReservationDate(int id) {
        ReservationDate reservationDate = null;
        sqlCode = "select * from reservationdates where idreservationDates = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            reservationDate = (ReservationDate) objectsList().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reservationDate;
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete from reservationdates where idreservationDates = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("ReservationDate with id = " + id + "is deleted from DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void addToDb(ReservationDate reservationDate) {
        sqlCode = "insert into reservationdates values(null, ?, ?, ?);";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setLong(1, reservationDate.getDateBegin());
            stmt.setLong(2, reservationDate.getDateEnd());
            stmt.setInt(3, reservationDate.getApartamentId());
            stmt.executeUpdate();
            System.out.println("Reservation date is added to DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
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
