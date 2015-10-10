package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.ReservationDao;
import com.gojava6.airbnb.model.Reservation;

import java.util.Date;
import java.util.List;

public class ReservationService {

    ReservationDao reservationDao = new ReservationDao();

    public void createReservation(int apartmentId, int userId, Date start, Date end) {
        reservationDao.createReservation(apartmentId, userId, start, end);
    }

    public void updateReservationDates(int reservation_id, Date start, Date end) {
        reservationDao.updateReservationDates(reservation_id, start, end);
    }

    public void deleteReservation(int reservationId) {
        reservationDao.deleteReservation(reservationId);
    }

    public List<Reservation> getReservationList() {
        return (List<Reservation>)(List<?>) reservationDao.getReservationList();
    }

    public List<Reservation> getReservationListOfApartment(int apartment_Id) {
        return (List<Reservation>)(List<?>) reservationDao.getReservationListOfApartment(apartment_Id);
    }

    public void printAllReservations(){
        List<Reservation> reservationList = getReservationList();

        for (Reservation reservation : reservationList) {
            System.out.println(reservation.toString());
        }
    }

}
