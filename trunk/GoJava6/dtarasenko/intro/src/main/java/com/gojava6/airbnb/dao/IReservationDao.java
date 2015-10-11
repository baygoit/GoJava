package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.Reservation;

import java.util.List;

public interface IReservationDao {

    void createReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    List<Reservation> getReservationList();
    List<Reservation> getApartmentReservationList(Integer apartmentId);
    Reservation getReservation(Integer reservationId);

}
