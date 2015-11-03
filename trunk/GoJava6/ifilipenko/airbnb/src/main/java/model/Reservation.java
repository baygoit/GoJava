package model;

import java.util.Date;

public class Reservation {
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

    public int getUserId() {
        return userId;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHome(int homeId) {
        this.homeId = homeId;
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
                "userId=" + userId +
                ", homeId=" + homeId +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
