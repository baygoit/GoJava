package com.donishchenko.airbnb.model;

import java.util.Date;

public class Reservation {
    private static int RESERVATION_ID = 0;
    private int id;
    private User user;
    private Apartment apartment;
    private Date start;
    private Date end;
    private String comment;

    public Reservation() {}

    public Reservation(User user, Apartment apartment, Date start, Date end, String comment) {
        this.id = ++RESERVATION_ID;
        this.user = user;
        this.apartment = apartment;
        this.start = start;
        this.end = end;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
