package airbnb.accounting;

import airbnb.model.Apartment;
import airbnb.model.RentType;
import airbnb.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    private Set<Apartment> apartments;
    private List<ReservationDates> reservation = new ArrayList<>();

    public Booking(Set<Apartment> apartments) {
        this.apartments = apartments;
    }

    public boolean isAvailable(int apartmentID, Date start, Date end) {
        for ( ReservationDates reserv: reservation ) {
            if (reserv.getApartmentId() == apartmentID ) {
                if (start.compareTo(reserv.getEnd()) < 0 || end.compareTo(reserv.getStart()) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeReservation(int apartmentID, int clientID, Date start, Date end) {
        reservation.add(new ReservationDates(apartmentID, clientID, start, end));
    }

    public void delAllApartmentReservation(int apartmentID) {
        Iterator<ReservationDates> it = reservation.iterator();
        while (it.hasNext()) {
            ReservationDates reserv = it.next();
            if(reserv.getApartmentId() == apartmentID) {
                it.remove();/// оповестить
            }
        }
    }

    public int search( String city, RentType rent, String startString, String endString ) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
        Date start = dt.parse(startString);
        Date end = dt.parse(endString);
        for ( Apartment apartment: apartments ) {
            if ( apartment.getRent() == rent && apartment.getCity() == city ) {
                if ( isAvailable(apartment.getApartmentID(), start, end) ) {
                    return apartment.getApartmentID();
                }
            }
        }
        return -1;
    }

    public void clean(Date date) {
        for ( ReservationDates reserv: reservation ) {
            if (date.compareTo(reserv.getEnd()) > 0 ) {
                reservation.remove(reserv);
            }
        }
    }
}
