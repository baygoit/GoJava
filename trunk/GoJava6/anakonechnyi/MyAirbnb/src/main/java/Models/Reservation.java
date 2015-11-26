package models;

import javax.persistence.*;
import java.util.Date;

/**
 * @autor A_Nakonechnyi
 * @date 30.09.2015.
 */

@Entity
@Table (name = "reservations")
public class Reservation {
    @Id
    @Column (name = "reserv_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idapartment")
    private Apartment apartment;
    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Column(name = "finish")
    @Temporal(TemporalType.DATE)
    private Date finish;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private User client;

    public Reservation(int reservId, Apartment apartment, Date start, Date finish, User client) {
        this.reservId = reservId;
        this.apartment = apartment;
        this.start = start;
        this.finish = finish;
        this.client = client;
        System.out.println("Succesfull reserve");
    }

    public Date getStart() {
        return start;
    }
    public Date getFinish() {
        return finish;
    }

    public Boolean clientChecker (User client) {
        return this.client == client;

    }

    public Apartment getApartment() {
        return apartment;
    }

    public User getClient() {
        return client;
    }

    public int getReservId() {
        return reservId;
    }


}
