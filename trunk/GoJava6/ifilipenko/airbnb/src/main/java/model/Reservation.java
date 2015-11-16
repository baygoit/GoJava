package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable{
    private int id;
    private int userId;
    private int homeId;
    private Date start;
    private Date end;
    private String comment;

    public Reservation(){
    }

    public Reservation(int userId, int homeId, Date start, Date end) {
        this.userId = userId;
        this.homeId = homeId;
        this.start = start;
        this.end = end;
    }

    //===============getters======================
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @Column(name = "user_id")
    public int getHomeId() {
        return homeId;
    }

    @Type(type="timestamp")
    @Column(name = "startdate")
    public Date getStart() {
        return start;
    }

    @Type(type="timestamp")
    @Column(name = "endatedate")
    public Date getEnd() {
        return end;
    }

    public String getComment() {
        return comment;
    }

    //===============setters======================

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }

    public void setHome(int homeId) {
        this.homeId = homeId;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "userId=" + userId +
                ", homeId=" + homeId +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
