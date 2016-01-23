package com.gojava6.modelSpring;

import java.util.Date;

public class Reservation {
    private Apartment apartment;
    private Date moveInDate;
    private Date moveOutDate;

    public Apartment getRoom() {
        return apartment;
    }

    public void setRoom(Apartment apartment) {
        this.apartment = apartment;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Date getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }
}
