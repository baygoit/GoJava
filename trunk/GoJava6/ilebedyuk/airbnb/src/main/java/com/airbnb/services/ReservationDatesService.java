package com.airbnb.services;

import com.airbnb.dao.IReservationDao;
import com.airbnb.model.ReservationDate;

import java.util.List;

/**
 * Created by Игорь on 17.10.2015.
 */
public class ReservationDatesService {
    private IReservationDao iReservationDao;

    public ReservationDatesService(IReservationDao iReservationDao) {
        this.iReservationDao = iReservationDao;
    }

    public List<ReservationDate> getAllReservationDates(){
        return iReservationDao.getReservationDateList();
    }

    public ReservationDate getReservationDateById(int id) {
        return iReservationDao.getReservationDate(id);
    }

    public void addReservationDate(ReservationDate reservationDate){
        iReservationDao.addToDb(reservationDate);
    }

    public void deleteReservationDate(int id){
        iReservationDao.delete(id);
    }

    public void printReservationDates(){
        List<ReservationDate> reservationDates = iReservationDao.getReservationDateList();
        for (ReservationDate reservationDate : reservationDates) {
            System.out.println(reservationDate);
        }
    }
}
