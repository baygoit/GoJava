package com.gojava6.modelHibernate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Reservation {
    private Apartment room;
    @Temporal (value = TemporalType.TIMESTAMP)
    private Date moveInDate;
    @Temporal (value = TemporalType.TIMESTAMP)
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
