package com.gojava6.airbnb.application;


public enum ApartmentType {

    PLACE ("place"),
    ROOM ("room"),
    APARTMENT ("apartment");

    private final String apartmentType;

    ApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getApartmentType() {
        return apartmentType;
    }
}
