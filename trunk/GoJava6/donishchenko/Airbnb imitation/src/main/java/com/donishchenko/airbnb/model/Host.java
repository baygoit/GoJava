package com.donishchenko.airbnb.model;

import com.google.common.base.Joiner;

public class Host extends User {
    public Host(String name, String surname, String email) {
        super(name, surname, email);
    }

    public Apartment createApartment(String city, ApartmentType type, boolean active) {
        return new Apartment(this, city, type, active);
    }

    @Override
    public String toString() {
        return Joiner.on("").join("Host{", super.toString(), "}");
    }
}
