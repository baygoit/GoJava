package com.airbnb;

/**
 * Created by Игорь on 26.09.2015.
 */
public class Apartment {
    enum ApartmentType {Place, Room, Apartment};
    private ApartmentType apartmentType;
    private String city;
    private String ownerName;

    private static int id = 0;

    public Apartment(ApartmentType apartmentType, String city, String ownerName) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.ownerName = ownerName;
        id += 1;
    }

    public ApartmentType getApartmentType() {
        //System.out.println(apartmentType);
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getCity() {
        //System.out.println(city);
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwnerName() {
        //System.out.println(ownerName);
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public static int getId() {
        return id;
    }
}
