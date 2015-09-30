package airbnb.reservation;

/**
 * Created by slavik on 27.09.15.
 */

import airbnb.model.RentType;

import java.util.Date;
import java.util.List;

public class Book {
    String city;
    RentType rentType;
    List<ReservationDates> reservationDates;

    public boolean isAvailable(Date start, Date end) {
        return false;
    }
    public void makeReservation(Date start, Date end) {
        //TODO
    }
}
