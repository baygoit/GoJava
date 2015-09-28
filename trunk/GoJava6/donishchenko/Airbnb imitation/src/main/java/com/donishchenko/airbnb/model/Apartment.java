package com.donishchenko.airbnb.model;

import com.donishchenko.airbnb.validation.Validator;
import com.google.common.base.Joiner;

public class Apartment {
    private static int APARTMENT_ID = 0;
    private int id;
    private Host host;
    private String city;
    private ApartmentType apartmentType;
    private boolean active;

    public Apartment(Host host, String city, ApartmentType apartmentType, boolean active) {
        this.id = ++APARTMENT_ID;
        this.host = host;
        this.city = city;
        this.apartmentType = apartmentType;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return Joiner.on("").join("Apartment{id='", id, "', hostId='", host.getId(), "', city='", city,
                "', type='", apartmentType, "', active='", active, "'}");
    }

    public boolean validate() {
        return Validator.validateCity(city);
    }
}
