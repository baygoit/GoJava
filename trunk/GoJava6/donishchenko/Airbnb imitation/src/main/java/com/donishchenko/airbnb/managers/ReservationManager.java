package com.donishchenko.airbnb.managers;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.Reservation;
import com.donishchenko.airbnb.model.User;

import java.util.Date;
import java.util.List;

public interface ReservationManager {
    public boolean makeReservation(User user, Apartment apartment, Date start, Date end, String comment);
    public boolean isAvailable(Apartment apartment, Date start, Date end);
    public Reservation getById(int id);
    public List<Reservation> getAll();
    public List<Reservation> getAllByApartment(Apartment apartment);
    public List<Reservation> getAllBetweenDates(Date start, Date end);
}
