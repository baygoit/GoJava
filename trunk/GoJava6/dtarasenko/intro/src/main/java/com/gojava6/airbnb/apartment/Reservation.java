package com.gojava6.airbnb.apartment;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Reservation {

    private int reservationId;
    private int apartmentId;
    private int userId;
    private long start;
    private long end;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date start = new Date(this.start);
        Date end = new Date(this.end);
        String stringStart = sdf.format(start);
        String stringEnd = sdf.format(end);

        return "Reservation{" +
                "reservationId=" + reservationId +
                ", apartmentId=" + apartmentId +
                ", userId=" + userId +
                ", start=" + stringStart +
                ", end=" + stringEnd +
                '}';
    }
}
