package com.gojava6.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shata on 17.09.2015.
 */
public class Host extends User {

    List<Apartment> apartments = new ArrayList<>();

    public Host(String name, String surname, String email, String city) {
        super(name, surname, email, city);
//        if (validation(name, surname, email, city)) {
//            register(this);
//        }
    }

    public void addApartments (Apartment apartment) {

        apartment.host = this;
        apartments.add(apartment);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }
}
