package com.donishchenko.airbnb.model;

import com.donishchenko.airbnb.validation.Validator;
import com.google.common.base.Joiner;

public class Apartment {
    private int id;
    private int hostId;
    private String city;
    private ApartmentType apartmentType;
    private boolean active;

    public Apartment(int hostId, String city, ApartmentType apartmentType, boolean active) {
        this.hostId = hostId;
        this.city = city;
        this.apartmentType = apartmentType;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Apartment)) return false;

        Apartment other = (Apartment) obj;

        return id == other.id &&
                hostId == other.hostId &&
                city.equals(other.city) &&
                apartmentType == other.apartmentType &&
                active == other.active;
    }

    @Override
    public String toString() {
        return Joiner.on("").join("Apartment{id='", id, "', hostId='", hostId, "', city='", city,
                "', type='", apartmentType, "', active='", active, "'}");
    }

    public boolean validate() {
        return Validator.validateCity(city);
    }
}
