package com.donishchenko.airbnb.model;

import com.google.common.base.Joiner;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "apartmentId")
    private Apartment apartment;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "comment")
    private String comment;

    public Reservation() {}

    public Reservation(User user, Apartment apartment, Date start, Date end, String comment) {
        this.user = user;
        this.apartment = apartment;
        this.start = start;
        this.end = end;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartmentId) {
        this.apartment = apartmentId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;

        if (!(obj instanceof Reservation)) return false;

        Reservation other = (Reservation) obj;

        return id.equals(other.id) &&
                user.equals(other.user) &&
                apartment.equals(other.apartment) &&
                start.equals(other.start) &&
                end.equals(other.end) &&
                comment.equals(other.comment);
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
        return Joiner.on("").join("Reservation{id='", id, "', user='", user,
                "', apartment='", apartment, "', start='", format.format(start), "', end='",
                format.format(end), "', comment='", comment, "'}");
    }
}
