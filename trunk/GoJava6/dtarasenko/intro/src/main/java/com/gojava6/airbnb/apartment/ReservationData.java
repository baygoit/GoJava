package com.gojava6.airbnb.apartment;

import java.util.Date;

public class ReservationData {

    private int apartmentId;
    private int userId;
    private long start;
    private long end;

    public ReservationData(int apartmentId, int userId, Date start, Date end) {
        this.apartmentId = apartmentId;
        this.userId = userId;
        this.start = start.getTime();
        this.end = end.getTime();
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public int getUserId() {
        return userId;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

}
