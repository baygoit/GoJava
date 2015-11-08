package com.donishchenko.airbnb.services;

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

//TODO booking service
public class BookingService {
    private static final Logger log = LogManager.getLogger(BookingService.class.getName());

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
            Reservation reservation = new Reservation(user.getId(), apartment.getId(), start, end, comment);
            SortOfDataBase.reservations.put(reservation.getId(), reservation);
            return true;
        }

        if (log.isInfoEnabled()) {
            logReservationRejected(user, apartment, start, end, "Apartment is unavailable for this dates");
        }
        return false;
    }

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
