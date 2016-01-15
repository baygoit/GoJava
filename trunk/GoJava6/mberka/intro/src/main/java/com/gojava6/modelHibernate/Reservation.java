package com.gojava6.modelHibernate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Reservations")
public class Reservation {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private int idReservation;
    @ManyToOne
    private Apartment apartment;
    @Column
    @Temporal (value = TemporalType.TIMESTAMP)
    private Date moveInDate;
    @Column
    @Temporal (value = TemporalType.TIMESTAMP)
    private Date moveOutDate;

    public int getIdReserve() {
        return idReservation;
    }

    public void setIdReserve(int idReserve) {
        this.idReservation = idReserve;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
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
