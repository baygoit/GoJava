package MyAirBnB.Model;

import java.util.Date;

/**
 * Created by macmini on 23.09.15.
 */
public class ReservationDate {

    private Date start;
    private Date end;

    public ReservationDate(Date start, Date end) {

        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
