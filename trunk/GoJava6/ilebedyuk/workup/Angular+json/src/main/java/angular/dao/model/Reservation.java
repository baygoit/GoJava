package angular.dao.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Игорь on 16.12.2015.
 */
@Entity
@Table(name="reservationdates")
public class Reservation {
    @Column(name = "startReservation")
    private Date dateBegin;

    @Column(name = "endReservation")
    private Date dateEnd;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idreservationdates")
    private int reservationDateId;
    @Column(name = "apartamentId")
    private int apartamentId;

    public Reservation(){}

    public Reservation(Date dateBegin, Date dateEnd, int apartamentId) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.apartamentId = apartamentId;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getReservationDateId() {
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

    @Override
    public String toString() {
        return "Reservation{" +
                "dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", reservationDateId=" + reservationDateId +
                ", apartamentId=" + apartamentId +
                '}';
    }
}
