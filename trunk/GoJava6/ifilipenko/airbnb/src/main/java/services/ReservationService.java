package services;

import dao.file.ReservationFileDao;
import model.Reservation;

public class ReservationService  {
    private ReservationFileDao rDao = new ReservationFileDao();

    public void bookHome(Reservation reservation) {
        rDao.create(reservation);
    }
}
