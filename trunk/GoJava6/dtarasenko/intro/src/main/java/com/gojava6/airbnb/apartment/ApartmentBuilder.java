package com.gojava6.airbnb.apartment;

import com.gojava6.airbnb.users.User;

public class ApartmentBuilder {

    private User user;
    private String city;
    private ApartmentType apartmentType;

    public void setUser(User user) {
        this.user = user;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public Apartment createApartment() {
        if (isCompleted() == false) {
            System.out.println("\nPlease fill all fields");
            return null; //TODO
        }
        System.out.println("\nApartment is created.");
        return new Apartment(user, city, apartmentType.getApartmentType());
    }

    private boolean isCompleted() {
        return (user != null) && (city != null) && (apartmentType != null);
    }
}
