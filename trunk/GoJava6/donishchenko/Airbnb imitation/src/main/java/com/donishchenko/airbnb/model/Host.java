package com.donishchenko.airbnb.model;

import com.donishchenko.airbnb.validation.Validator;

public class Host extends User {
    private String city;
    private ApartmentType apartmentType;

    public Host(String name, String surname, String email, String city, ApartmentType apartmentType) {
        super(name, surname, email);
        this.city = city.trim();
        this.apartmentType = apartmentType;
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

    @Override
    public boolean validate() {
        return super.validate() &&
                Validator.validateCity(city);
    }

    @Override
    public String toString() {
        return "Host{" +
                "city='" + city + '\'' +
                ", apartmentType=" + apartmentType +
                '}';
    }
}
