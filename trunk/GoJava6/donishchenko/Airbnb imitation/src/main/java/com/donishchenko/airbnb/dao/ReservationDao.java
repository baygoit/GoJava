package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Reservation;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ReservationDao {
    int save(Reservation reservation) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(int id, Reservation reservation) throws SQLException;
    Reservation get(int id) throws SQLException;
    List<Reservation> getAll() throws SQLException;
    List<Reservation> getAllByApartment(int apartmentId) throws SQLException;
    List<Reservation> getAllByUser(int userId) throws SQLException;
    List<Reservation> getAllByHost(int userId) throws SQLException;
    List<Reservation> getAllBetweenDates(Date start, Date end) throws SQLException;
}
