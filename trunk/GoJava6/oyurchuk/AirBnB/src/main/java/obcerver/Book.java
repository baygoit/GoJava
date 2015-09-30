package obcerver;

import java.util.Date;
import java.util.List;

/**
 * Created by macmini on 23.09.15.
 */
public class Book {
    String city;
    String apartmentType;
    List<ReservationDate> reservationDates;

    public boolean isAvailable(Date starts, Date end){

        return false;
    }

    public void makeReservation(Date start, Date end){
        return;
    }

}

