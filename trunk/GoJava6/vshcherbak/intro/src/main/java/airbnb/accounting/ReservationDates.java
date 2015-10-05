package airbnb.accounting;

import java.util.Date;

public class ReservationDates {
    private int apartmentID;
    private int clientID;
    private Date start;
    private Date end;

    public ReservationDates(int apartmentId, int clientID, Date start, Date end) {
        this.apartmentID = apartmentId;
        this.clientID = clientID;
        this.start = start;
        this.end = end;
    }

    public int getApartmentId() { return apartmentID; }
    public int getClientID() { return clientID; }
    public Date getStart() { return start; }
    public Date getEnd() { return end; }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
