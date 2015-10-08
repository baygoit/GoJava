package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.SortOfDataBase;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.Reservation;
import com.donishchenko.airbnb.model.User;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    public static final Logger log = LogManager.getLogger(ReservationDaoImpl.class.getName());

    @Override
    public boolean makeReservation(User user, Apartment apartment, Date start, Date end, String comment) {
        if (end.before(start)) {
            if (log.isInfoEnabled()) {
                logReservationRejected(user, apartment, start, end, "Invalid date");
            }
            return false;
        }

        if (isAvailable(apartment, start, end)) {
            if (log.isInfoEnabled()) {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
                log.info(Joiner.on("").join("Reservation accepted: UserID='", user.getId(),
                        "', apartmentID='", apartment.getId(), "', start='", format.format(start),
                        "', end='", format.format(end), "'"));
            }
            Reservation reservation = new Reservation(user, apartment, start, end, comment);
            SortOfDataBase.reservations.put(reservation.getId(), reservation);
            return true;
        }

        if (log.isInfoEnabled()) {
            logReservationRejected(user, apartment, start, end, "Apartment is unavailable for this dates");
        }
        return false;
    }

    @Override
    public boolean isAvailable(Apartment apartment, Date start, Date end) {
        Collection<Reservation> reservations = SortOfDataBase.reservations.values();
        for (Reservation reservation : reservations) {
            if (intersects(reservation, start, end)) {
                System.out.println("Sorry :(");
                return false;
            }
        }
        System.out.println("SUCCESSFUL Reservation");
        return true;
    }

    @Override
    public Reservation getById(int id) {
        return SortOfDataBase.reservations.get(id);
    }

    @Override
    public List<Reservation> getAll() {
        return new LinkedList<>(SortOfDataBase.reservations.values());
    }

    @Override
    public List<Reservation> getAllByApartment(Apartment apartment) {
        List<Reservation> list = new LinkedList<>();

        for (Reservation reservation : SortOfDataBase.reservations.values()) {
            if (reservation.getApartment().getId() == apartment.getId()) {
                list.add(reservation);
            }
        }

        return list;
    }

    @Override
    public List<Reservation> getAllBetweenDates(Date start, Date end) {
        List<Reservation> list = new LinkedList<>();

        for (Reservation reservation : SortOfDataBase.reservations.values()) {
            if ((reservation.getStart().after(start) || reservation.getStart().equals(start)) &&
                (reservation.getEnd().before(end) || reservation.getEnd().equals(end))) {
                list.add(reservation);
            }
        }

        return list;
    }

    private boolean intersects(Reservation reservation, Date start, Date end) {
        return !(start.after(reservation.getEnd()) || end.before(reservation.getStart()));
    }

    private void logReservationRejected(User user, Apartment apartment, Date start, Date end, String message) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
        log.info(Joiner.on("").join("Reservation rejected: UserID='", user.getId(),
                "', apartmentID='", apartment.getId(), "', start='", format.format(start),
                "', end='", format.format(end), "' | Reason - ", message));
    }
}
