package com.shcherbak.model;

import java.util.Date;

public class Apartment {
    private long apartmentID;
    private long hostID;
    private String rent;
    private String city;
    private String street;
    private int house;
    private int room;
    private Date date;
    String comment;

    public Apartment() {}
    public Apartment(long apartmentID, int hostID, String rent, String city, String street,
                     int house, int room, Date date, String comment) {
        this.apartmentID = apartmentID;
        this.hostID = hostID;
        this.rent = rent;
        this.city = city;
        this.street = street;
        this.house = house;
        this.room = room;
        this.date = date;
        this.comment = comment;
    }

    public long getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(long apartmentID) {
        this.apartmentID = apartmentID;
    }

    public long getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        if (apartmentID != apartment.apartmentID) return false;
        if (house != apartment.house) return false;
        if (room != apartment.room) return false;
        if (!city.equals(apartment.city)) return false;
        if (!rent.equals(apartment.rent)) return false;
        if (!street.equals(apartment.street)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)apartmentID;
        result = 31 * result + rent.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + house;
        return result;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentID=" + apartmentID +
                ", hostID=" + hostID +
                ", rent=" + rent +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", room=" + room +
                '}';
    }
}