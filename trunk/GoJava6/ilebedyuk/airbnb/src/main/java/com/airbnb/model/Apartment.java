package com.airbnb.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Created by Игорь on 26.09.2015.
 */
public class Apartment {
    private String apartmentType;
    private String city;
    private int ownerId;
    private int idAparnament;
//    private Map<ReservationDate,Apartment> reservationDates = new HashMap<ReservationDate, Apartment>();

    private static final Logger log = Logger.getLogger(Apartment.class);

//    public Map<ReservationDate, Apartment> getReservationDates() {
//        return reservationDates;
//    }
//
//    public void setReservationDates(Map<ReservationDate, Apartment> reservationDates) {
//        this.reservationDates = reservationDates;
//    }

    public Apartment(String apartmentType, String city, int ownerId) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.ownerId = ownerId;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public String getCity() {
        return city;
    }

    public int getIdAparnament() {
        return idAparnament;
    }

    public void setIdAparnament(int idAparnament) {
        this.idAparnament = idAparnament;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return "Id: '" + this.idAparnament +
                "', Apartament type: '" + this.apartmentType +
                "', City: '" + this.city +
                "', Owner id: '" + this.ownerId + "'";
    }

//    public boolean isAvaible(ReservationDate period) {
//        for (Map.Entry<ReservationDate, Apartment> entry : reservationDates.entrySet()) {
//            for (long i = entry.getKey().getDateBegin(); i < entry.getKey().getDateEnd(); i++) {
//                for (long j = period.getDateBegin(); j < period.getDateEnd(); j++) {
//                    if (i == j && getApartmentType() == entry.getValue().getApartmentType()){
//                        log.info("That apartment in this period isn't available");
//                        return false;
//
//                    }
//                }
//
//            }
//        }
//        return true;
//    }
}
