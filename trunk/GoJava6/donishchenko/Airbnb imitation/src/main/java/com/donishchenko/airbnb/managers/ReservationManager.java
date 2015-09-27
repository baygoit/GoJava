package com.donishchenko.airbnb.managers;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.User;

import java.util.Date;

public interface ReservationManager {
    void makeReservation(User user, Apartment apartment, Date start, Date end, String comment);
}
