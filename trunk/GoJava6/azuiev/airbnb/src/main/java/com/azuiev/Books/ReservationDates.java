package com.azuiev.Books;

import java.util.Date;

/**
 * Created by Lera on 23.09.2015.
 */
public class ReservationDates {
    private Date begin;
    private Date end;

    public ReservationDates(Date begin, Date end) {
        if (begin.compareTo(end)>=0){
            throw new IllegalArgumentException();
        }
        this.begin = begin;
        this.end = end;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

}
