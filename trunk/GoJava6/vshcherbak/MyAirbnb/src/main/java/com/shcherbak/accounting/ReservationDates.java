package com.shcherbak.accounting;

import java.util.Date;

public class ReservationDates {
    private int apartment_id;

    private int client_id;
    private Date start;
    private Date end;

    public ReservationDates(int apartmentId, int clientID, Date start, Date end) {
        this.apartment_id = apartmentId;
        this.client_id = clientID;
        this.start = start;
        this.end = end;
    }

    public int getApartmentId() { return apartment_id; }
    public int getClient_id() { return client_id; }
    public Date getStart() { return start; }
    public Date getEnd() { return end; }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ReservationDates{" +
                "apartment_id=" + apartment_id +
                ", client_id=" + client_id +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
