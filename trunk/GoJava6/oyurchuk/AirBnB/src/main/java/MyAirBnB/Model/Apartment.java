package MyAirBnB.Model;

import MyAirBnB.Enum.ApartmentType;

import java.util.Date;
import java.util.List;

/**
 * Created by macmini on 23.09.15.
 */
public class Apartment {
    private String city;
    private ApartmentType apartmentType;


    private List<ReservationDate> reservationDates;// лист,  где хранятся периоды (даты) которые заняты
    private String address;


    public Apartment(String city, ApartmentType  apartmentType, String address) {
        this.city = city;
        this.apartmentType = apartmentType;
        this.address = address;
    }

    public boolean isAvailable(Date starts, Date end){

        // проверить на  null и на то, что end >= starts
        for (ReservationDate reservationDate :reservationDates) {
            if (end.compareTo(reservationDate.getStart()) < 0){
                continue;

            } else if (starts.compareTo(reservationDate.getEnd()) > 0){
                continue;

            } else {
                return false;
            }

        }

        return true;
    }

    public void makeReservation(Date start, Date end){

        if (isAvailable(start,end)){
            reservationDates.add(new ReservationDate(start, end));
        }


    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

}

