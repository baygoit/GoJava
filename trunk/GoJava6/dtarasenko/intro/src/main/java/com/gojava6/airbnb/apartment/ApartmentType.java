package com.gojava6.airbnb.apartment;


public enum ApartmentType {

    PLACE ("Place"),
    ROOM ("Room"),
    APARTMENT ("Apartment");

    private final String apartmentType;

    ApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getApartmentType() {
        return apartmentType;
    }
}
