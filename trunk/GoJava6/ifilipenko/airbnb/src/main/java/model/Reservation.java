package model;

import java.util.Date;

public class Reservation {
    private User user;
    private HomeType homeType;
    private Date start;
    private Date end;
    private String comment;

    public Reservation(User user, HomeType apartment, Date start, Date end, String comment) {
        this.user = user;
        this.homeType = apartment;
        this.start = start;
        this.end = end;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HomeType getHomeType() {
        return homeType;
    }

    public void setHomeType(HomeType homeType) {
        this.homeType = homeType;
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
                ", homeType=" + homeType +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
