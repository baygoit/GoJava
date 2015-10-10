package com.azuiev.model;

import com.azuiev.model.User;

import java.util.Date;

/**
 * Created by Lera on 23.09.2015.
 */
public class Reservation {
    private Date begin;
    private Date end;
    private User user;

    public Reservation(User user, Date begin, Date end) {
        if (begin.compareTo(end) >= 0) {
            throw new IllegalArgumentException();
        }
        this.begin = begin;
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

}
