package com.gojava6.airbnb.apartment;

import com.gojava6.airbnb.user.User;
import com.gojava6.airbnb.reservation.ReservationDates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shata on 28.09.2015.
 */
public class Apartment {

    public ApartType type;
    public User user;
    public String city;
    public int apartmentID;

    public List<ReservationDates> reservationDates = new ArrayList<>();

    public Apartment(ApartType type, String city) {
        this.type = type;
        this.city = city;
    }

    public String getType() {
        return type.toString();
    }
}
