package com.airbnb.user;
import com.airbnb.apartment.*;

import java.time.LocalDate;

/**
 * Created by root on 19.09.15.
 */
public class Host extends User {

    private String city;
    private Apartment apartment = new Apartment();
    public Host(String name, String surname, String email, String city, LocalDate firstDayAvailable,
                LocalDate lastDayAvailable, ApartmentType apartmentType) {
        super(name, surname, email);
        this.city = city;
        this.apartment.setFirstDayAvailable(firstDayAvailable);
        this.apartment.setLastDayAvailable(lastDayAvailable);
        this.apartment.setApartmentType(apartmentType);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }


}
