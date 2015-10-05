package com.gojava6.airbnb.apartment;

import com.gojava6.airbnb.users.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apartment {

    private static final Logger log = Logger.getLogger(Apartment.class);
    private static int apartmentIdCounter;
    private int apartmentId;
    private String city;
    private ApartmentType apartmentType;
    private List<ReservationDate> reservationDateList;

    public Apartment(String city, ApartmentType apartmentType) {
        apartmentIdCounter += 1;
        this.apartmentId = apartmentIdCounter;
        this.city = city;
        this.apartmentType = apartmentType;
        this.reservationDateList = new ArrayList<ReservationDate>();
    }

    public String getCity() {
        return city;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void reserve(Date startDate, Date endDate, User user) {

        log.info("Start date: " + startDate.getDate() + " " + (startDate.getMonth() + 1)
                + " " + (startDate.getYear() + 1900) + ". End date: " + endDate.getDate()
                + " " + (endDate.getMonth() + 1) + " " + (endDate.getYear() + 1900) + ".");

        long start = startDate.getTime();
        long end = endDate.getTime();

        if (start > end) {
            System.out.println("\nPlease corrent input dates");
            log.info("Input date error");
        }
        else {
            if (isAvailable(start, end)) {
                reservationDateList.add(new ReservationDate(user, end, start));
                System.out.println("Reservation is completed");
                log.info("Reservation is completed");

            }
            else {
                System.out.println("Reservation is not available");
                log.info("Reservation is not available");
            }
        }
    }

    public boolean isAvailable(long start, long end) {
        if (reservationDateList.isEmpty()) {
            System.out.println("\nApartment is available");
            return true;
        } else {
            for (ReservationDate rd : reservationDateList) {
                if (!(start < rd.getStart() && end < rd.getStart()) &&
                        !(start > rd.getEnd() && end > rd.getEnd())) {
                    System.out.println("\nApartment is not available");
                    return false;
                }
            }
        }
        System.out.println("\nApartment is available");
        return true;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + apartmentId +
                ", city='" + city + '\'' +
                ", apartmentType=" + apartmentType +
                '}';
    }

}
