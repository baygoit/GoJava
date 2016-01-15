package com.gojava6.modelSpring;

import java.util.Date;

public class Reservation {
    private Apartment room;
    private Date moveInDate;
    private Date moveOutDate;

    public Apartment getRoom() {
        return room;
    }

    public void setRoom(Apartment room) {
        this.room = room;
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
