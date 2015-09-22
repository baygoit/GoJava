package com.gojava6.airbnb.users;

import com.gojava6.airbnb.application.ApartmentType;

public class Host extends User{
    private String city;
    private ApartmentType apartmentType;

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

}
