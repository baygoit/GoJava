package com.gojava6.airbnb.apartment;

import com.gojava6.airbnb.users.User;

public class Apartment {

    private static int apartmentIdCounter;
    private int apartmentId;
    private int userId;
    private String city;
    private String apartmentType;

    public Apartment(User user, String city, String apartmentType) {
        apartmentIdCounter += 1;
        this.apartmentId = apartmentIdCounter;
        this.userId = user.getUserId();
        this.city = city;
        this.apartmentType = apartmentType;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public int getUserId() {
        return userId;
    }

    public String getCity() {
        return city;
    }

    public String getApartmentType() {
        return apartmentType;
    }

}
