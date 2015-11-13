package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationDao {
    void save(Reservation reservation);
    Reservation get(Integer id);
    boolean update(Reservation reservation);
    boolean delete(Integer id);
    List<Reservation> getAll();
    List<Reservation> getAllByApartment(Integer apartmentId);
    List<Reservation> getAllByUser(Integer userId);
    List<Reservation> getAllBetweenDates(Date start, Date end);
}
