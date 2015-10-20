package com.airbnb.model;

/**
 * Created by Игорь on 11.10.2015.
 */
public enum ApartmentType {
    PLACE("Place"),
    ROOM("Room"),
    APARTAMENT("Apartament");

    private final String apartmentType;

    ApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getApartmentType() {
        return apartmentType;
    }
}
