package com.airbnb.dao;

import com.airbnb.model.Apartment;
import com.airbnb.model.ReservationDate;

import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public interface IReservationDao {
    List<ReservationDate> getReservationDateList();
    ReservationDate getReservationDate(int id);
    void delete(int id);
    void addToDb(ReservationDate reservationDate);
}
