package airbnb.common;

import airbnb.reservation.ReservationDates;
import java.util.Date;
import java.util.List;

public interface Booking {
    public boolean isAvailable(Date start, Date end);
    List<ReservationDates> reservation = null;
}
