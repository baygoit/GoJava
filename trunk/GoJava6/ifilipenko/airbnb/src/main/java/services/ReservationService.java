package services;

import dao.io.ReservationIODao;
import model.Reservation;

public class ReservationService  {
    private ReservationIODao rDao = new ReservationIODao();

    public void bookHome(Reservation reservation) {
        rDao.create(reservation);
    }
}
