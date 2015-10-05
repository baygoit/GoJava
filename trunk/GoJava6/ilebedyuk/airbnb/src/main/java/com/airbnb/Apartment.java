package com.airbnb;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Created by Игорь on 26.09.2015.
 */
public class Apartment {
    enum ApartmentType {Place, Room, Apartment};
    private ApartmentType apartmentType;
    private String city;
    private String ownerName;
    private Map<ReservationDate,Apartment> reservationDates = new HashMap<ReservationDate, Apartment>();

    private static final Logger log = Logger.getLogger(Apartment.class);

    public Map<ReservationDate, Apartment> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(Map<ReservationDate, Apartment> reservationDates) {
        this.reservationDates = reservationDates;
    }

    public Apartment(ApartmentType apartmentType, String city, String ownerName) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.ownerName = ownerName;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isAvaible(ReservationDate period) {
        for (Map.Entry<ReservationDate, Apartment> entry : reservationDates.entrySet()) {
            for (long i = entry.getKey().getDateBegin(); i < entry.getKey().getDateEnd(); i++) {
                for (long j = period.getDateBegin(); j < period.getDateEnd(); j++) {
                    if (i == j && getApartmentType() == entry.getValue().getApartmentType()){
                        log.info("That apartment in this period isn't available");
                        return false;

                    }
                }

            }
        }
        return true;
    }
}
