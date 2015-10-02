package airbnb.reservation;

import airbnb.common.Booking;
import airbnb.model.RentType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apartment implements Booking {
    private static int totalApartmentID = 0;
    private int apartmentID;
    private int hostID;
    private RentType rent;
    private String city;
    private List<ReservationDates> reservation = new ArrayList<>();

    public Apartment(int hostID, RentType rent ,String city) {
        this.city = city;
        this.rent = rent;
        this.hostID = hostID;
        apartmentID = totalApartmentID++;
    }

    public static int getTotalApartmentID() {
        return totalApartmentID;
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public int getHostID() {
        return hostID;
    }

    public RentType getRent() {
        return rent;
    }

    public String getCity() {
        return city;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public void setRent(RentType rent) {
        this.rent = rent;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean isAvailable(Date start, Date end) {
        for ( ReservationDates reserv: reservation ) {
            if (start.compareTo(reserv.getEnd()) < 0 || end.compareTo(reserv.getStart()) > 0 ) {
                return  false;
            }
        }
        return true;
    }

    public void makeReservation(int clientID, Date start, Date end) {
        reservation.add(new ReservationDates(clientID, start, end));
    }

    public void clean(Date date) {
        for ( ReservationDates reserv: reservation ) {
            if (date.compareTo(reserv.getEnd()) > 0 ) {
                reservation.remove(reserv);
            }
        }
    }
}