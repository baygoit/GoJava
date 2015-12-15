package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "home_id")
    private Home home;

    @Type(type="timestamp")
    @Column(name = "startdate")
    private Date start;

    @Type(type="timestamp")
    @Column(name = "endatedate")
    private Date end;

    @Transient
    private String comment;

    //-- file --
    @Transient
    private int userId;

    @Transient
    private int homeId;

    public Reservation(){
    }

    public Reservation(User user, Home home, Date start, Date end) {
        this.user = user;
        this.home = home;
        this.start = start;
        this.end = end;
    }

    //===============getters======================

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Home getHome() {
        return home;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getComment() {
        return comment;
    }

    //-- file -->
    public int getUserId() {
        return userId;
    }

    public int getHomeId() {
        return homeId;
    }


    //===============setters======================

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHome(Home home) {
        this.home = home;
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

    //-- file -->
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "user=" + user.toString() +
                ", home=" + home.toString() +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
