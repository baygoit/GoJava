package com.donishchenko.airbnb.managers;

import com.donishchenko.airbnb.SortOfDataBase;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.Reservation;
import com.donishchenko.airbnb.model.User;

import java.util.Collection;
import java.util.Date;

public class ReservationManagerImpl implements ReservationManager {
    @Override
    public void makeReservation(User user, Apartment apartment, Date start, Date end, String comment) {
        if (end.before(start)) {
            return;
        }

        if (isAvailable(apartment, start, end)) {
            Reservation reservation = new Reservation(user, apartment, start, end, comment);
            SortOfDataBase.reservations.put(reservation.getId(), reservation);
        }
    }

    private boolean isAvailable(Apartment apartment, Date start, Date end) {
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
}
