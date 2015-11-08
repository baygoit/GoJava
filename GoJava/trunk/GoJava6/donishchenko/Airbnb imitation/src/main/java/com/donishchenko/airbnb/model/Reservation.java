package com.donishchenko.airbnb.model;

import com.google.common.base.Joiner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private int id;
    private int userId;
    private int apartmentId;
    private Date start;
    private Date end;
    private String comment;

    public Reservation() {}

    public Reservation(int userId, int apartmentId, Date start, Date end, String comment) {
        this.userId = userId;
        this.apartmentId = apartmentId;
        this.start = start;
        this.end = end;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getApartmenId() {
        return apartmentId;
    }

    public void setApartment(int apartmentId) {
        this.apartmentId = apartmentId;
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

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
        return Joiner.on("").join("Reservation{id='", id, "', userId='", userId,
                "', apartmentId='", apartmentId, "', start='", format.format(start), "', end='",
                format.format(end), "', comment='", comment, "'}");
    }
}
