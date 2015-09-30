package com.gojava6.airbnb;

import java.util.GregorianCalendar;

/**
 * Created by sergiigetman on 9/23/15.
 */
public class ReservationDates {
    GregorianCalendar start;
    GregorianCalendar end;
    Apartment apartment;

    public ReservationDates(GregorianCalendar start,  GregorianCalendar end, Apartment apartment) {
        this.start = start;
        this.end = end;
        this.apartment = apartment;
    }
}
