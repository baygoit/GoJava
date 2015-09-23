package com.airbnb;

/**
 * Created by Игорь on 20.09.2015.
 */
public class Host extends User {
    private String city;
    enum ApartmentType {Place, Room, Apartment};
    private ApartmentType apartmentType;

    public Host(String name, String surname, String email, String city, ApartmentType apartmentType) throws Exception {
        super(name, surname, email);
        if (Host.validateName(city) == true) {
            this.city = city;
        } else throw new Exception();
        this.apartmentType = apartmentType;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public String getCity() {
        return city;
    }

}
