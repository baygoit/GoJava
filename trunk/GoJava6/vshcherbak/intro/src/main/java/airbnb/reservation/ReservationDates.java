package airbnb.reservation;

import java.util.Date;

public class ReservationDates {
    private int clientID;
    private Date start;
    private Date end;

    public ReservationDates(int clientID, Date start, Date end) {
        this.clientID = clientID;
        this.start = start;
        this.end = end;
    }

    public int getClientID() { return clientID; }
    public Date getStart() { return start; }
    public Date getEnd() { return end; }
}
