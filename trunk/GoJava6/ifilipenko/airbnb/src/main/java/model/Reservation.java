package model;

import java.util.Date;

public class Reservation {
    private User user;
    private Home home;
    private Date start;
    private Date end;
    private String comment;

    public Reservation(User user, Home home, Date start, Date end) {
        this.user = user;
        this.home = home;
        this.start = start;
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
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
    public String toString() {
        return "Reservation{" +
                "user=" + user +
                ", home=" + home +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
