package com.gojava6.airbnb.reservation;

import com.gojava6.airbnb.apartment.Apartment;

import java.util.Date;

/**
 * Created by sergiigetman on 9/23/15.
 */
public class ReservationDates {
    Date start;
    Date end;
    Apartment apartment;

    public ReservationDates(Date start,  Date end, Apartment apartment) {
        this.start = start;
        this.end = end;
        this.apartment = apartment;
    }
}
