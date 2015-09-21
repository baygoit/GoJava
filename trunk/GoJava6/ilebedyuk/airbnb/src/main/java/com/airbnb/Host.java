package com.airbnb;

/**
 * Created by Игорь on 20.09.2015.
 */
public class Host extends User {
    private String city;
    enum ApartmentType {Place, Room, Apartment};

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
