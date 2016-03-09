package com.shcherbak.accounting;

import java.util.Date;

public class ReservationDates {
    private long reservationID;
    private long apartment_id;
    private long client_id;
    private Date start;
    private Date end;
    private Date date;
    private String comments;

    public ReservationDates() {}

    public ReservationDates( long apartment_id, long client_id, Date start, Date end, Date date, String comments) {
        //this.reservationID = reservationID;
        this.apartment_id = apartment_id;
        this.client_id = client_id;
        this.start = start;
        this.end = end;
        this.date = date;
        this.comments = comments;
    }

    public long getReservationID() {
        return reservationID;
    }

    public void setReservationID(long reservationID) {
        this.reservationID = reservationID;
    }

    public long getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(long apartment_id) {
        this.apartment_id = apartment_id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationDates that = (ReservationDates) o;

        if (apartment_id != that.apartment_id) return false;
        if (client_id != that.client_id) return false;
        if (reservationID != that.reservationID) return false;
        if (!end.equals(that.end)) return false;
        if (!start.equals(that.start)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (reservationID ^ (reservationID >>> 32));
        result = 31 * result + (int) (apartment_id ^ (apartment_id >>> 32));
        result = 31 * result + (int) (client_id ^ (client_id >>> 32));
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ReservationDates{" +
                "reservationID=" + reservationID +
                ", apartment_id=" + apartment_id +
                ", client_id=" + client_id +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
