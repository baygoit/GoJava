package com.airbnb.model;


import java.text.SimpleDateFormat;

/**
 * Created by Игорь on 27.09.2015.
 */
public class ReservationDate {

    private long dateBegin;
    private long dateEnd;
    private int reservationDateId;
    private int apartamentId;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public ReservationDate(){}

    public ReservationDate(long dateBegin, long dateEnd, int apartamentId) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.apartamentId = apartamentId;
    }

    public long getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(long dateBegin) {
        this.dateBegin = dateBegin;
    }

    public long getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(long dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getReservationDateId(int idreservationdates) {
        return reservationDateId;
    }

    public void setReservationDateId(int reservationDateId) {
        this.reservationDateId = reservationDateId;
    }

    public int getApartamentId() {
        return apartamentId;
    }

    public void setApartamentId(int apartamentId) {
        this.apartamentId = apartamentId;
    }

    public void getPeriod(){
        System.out.println("Period is begin " + dateBegin + " and end " + dateEnd);
    }

    @Override
    public String toString() {
        return "Id: '" + this.reservationDateId +
                "', date of start: '" + sdf.format(this.dateBegin) +
                "', date of end: '" + sdf.format(this.dateEnd) +
                "', apartamentId: '" + this.apartamentId + "'";
    }
}
