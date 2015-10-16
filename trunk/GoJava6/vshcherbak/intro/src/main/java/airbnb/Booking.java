package airbnb;

import airbnb.accounting.ReservationDates;
import airbnb.common.Processor;
import airbnb.model.Apartment;
import airbnb.model.RentType;
import airbnb.model.User;
import airbnb.processing.SQLProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    private Set<Apartment> apartments;
    private List<ReservationDates> reservation;// = new ArrayList<>();
    private Processor processor;

    public Booking(Processor processor) {
        this.processor = processor;
    }

   /* public boolean isAvailable(int apartmentID, Date start, Date end) {
        for ( ReservationDates reserv: reservation ) {
            if (reserv.getApartmentId() == apartmentID ) {
                if (start.compareTo(reserv.getEnd()) < 0 || end.compareTo(reserv.getStart()) > 0) {
                    return false;
                }
            }
        }
        return true;
    }*/

    public void makeReservation(int apartmentID, int clientID, String startString, String endString)throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dt.parse(startString);
        Date end = dt.parse(endString);
        processor.addReservation(apartmentID, clientID, start, end);
    }

    public List<Apartment> search( String city, RentType rent, String startString, String endString ) throws ParseException {
        List<Apartment> apartments;
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dt.parse(startString);
        Date end = dt.parse(endString);
        apartments = processor.search(city, rent, start, end);
        return apartments;
    }

    public void clean(Date date) {
        for ( ReservationDates reserv: reservation ) {
            if (date.compareTo(reserv.getEnd()) > 0 ) {
                reservation.remove(reserv);
            }
        }
    }
}
