package com.gojava6.collection;

import java.util.Date;
import java.util.List;

/**
 * Created by sergiigetman on 9/23/15.
 */
public class Book {
    String city;
    String apartmentType;
    List<ReservationDates> reservationDates;

    public boolean isAvailable(Date start, Date end) {
        return false;
    }
     public void makeReservation(Date start, Date end) {
         //TODO
     }
}
