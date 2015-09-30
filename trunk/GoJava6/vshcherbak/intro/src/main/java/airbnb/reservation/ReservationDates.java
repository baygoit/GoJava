package airbnb.reservation;

import airbnb.model.RentType;

import java.util.Date;

public class ReservationDates {
    private int hostID;
    private int clientID;
    private Date start;
    private Date end;
    private RentType rent;

    ReservationDates(int hostID, int clientID, Date start, Date end, RentType rent) {
        this.hostID = hostID;
        this.clientID = clientID;
        this.start = start;
        this.end = end;
        this.rent = rent;
    }

    public int getHostID() { return hostID; }
    public int getClientID() { return clientID; }
    public Date getStart() { return start; }
    public Date getEnd() { return end; }
    public  RentType getRent() { return rent; }
}
