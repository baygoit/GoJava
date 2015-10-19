package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.IReservationDao;
import com.gojava6.airbnb.model.Reservation;

import java.util.Date;
import java.util.List;

public class ReservationService {

    IReservationDao iReservationDao;

    public ReservationService(IReservationDao iReservationDao) {
        this.iReservationDao = iReservationDao;
    }

    public void createReservation(int apartmentId, int userId, Date start, Date end) {
        Reservation reservation = new Reservation();
        reservation.setApartmentId(apartmentId);
        reservation.setUserId(userId);
        reservation.setStart(start.getTime());
        reservation.setEnd(end.getTime());

        iReservationDao.createReservation(reservation);
    }

    public void updateReservationDates(int reservationId, Date start, Date end) {
        Reservation reservation = iReservationDao.getReservation(reservationId);
        reservation.setStart(start.getTime());
        reservation.setEnd(end.getTime());
        iReservationDao.updateReservation(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        iReservationDao.deleteReservation(reservation);
    }

    public List<Reservation> getReservationList() {
        return iReservationDao.getReservationList();
    }

    public List<Reservation> getApartmentReservationList(int apartmentId) {
        return iReservationDao.getApartmentReservationList(apartmentId);
    }

    public Reservation getReservation(int reservationId) {
        return iReservationDao.getReservation(reservationId);
    }

    public void printAllReservations(){
        List<Reservation> reservationList = getReservationList();

        for (Reservation reservation : reservationList) {
            System.out.println(reservation.toString());
        }
    }

}
