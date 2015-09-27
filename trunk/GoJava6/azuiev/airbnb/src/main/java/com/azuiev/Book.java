package com.azuiev;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 23.09.2015.
 */
public class Book {
    String city;
    ApartType apartType;
    List<ReservationDates> periods = new LinkedList<ReservationDates>();

    public void reserve(Date start, Date end) {
        //TODO
    }
}
