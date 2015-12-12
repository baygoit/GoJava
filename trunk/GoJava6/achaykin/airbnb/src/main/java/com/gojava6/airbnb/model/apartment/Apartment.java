package com.gojava6.airbnb.model.apartment;


import com.gojava6.airbnb.Exception.ApartmentReserveException;
import com.gojava6.airbnb.model.user.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Apartment {

    private int apartmentID;
    private int hostID;
    private ApartmentType apartmentType;
    private CityType city;  //todo string city
    private String address; //todo delete
    private int rooms;  //  todo delete
    private int accommodates;  // todo delete
    private int squareFootage;  // todo delete
    private List<String> reviews; //todo
    private List<ReserveApartment> reserveBook = new ArrayList<ReserveApartment>(); //todo

    public Apartment(ApartmentType apartment, CityType city, String address, int hostID) {
        this.apartmentType = apartment;
        this.city = city;
        this.address = address;
        this.hostID = hostID;
    }

    public Apartment(int apartmentId, ApartmentType apartment, CityType city, String address, int hostID) {
        this.apartmentType = apartment;
        this.city = city;
        this.address = address;
        this.apartmentID = apartmentId;
        this.hostID = hostID;
    }

    public Apartment(int apartmentId, int hostID, ApartmentType apartment, CityType city, String address, int rooms, int accommodates, int squareFootage) {
        this.apartmentID = apartmentId;
        this.hostID = hostID;
        this.apartmentType = apartment;
        this.city = city;
        this.apartmentID = apartmentId;
        this.address = address;
        this.rooms = rooms;
        this.accommodates = accommodates;
        this.squareFootage = squareFootage;
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-mm-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public void reserveApartment(User renter, Date start, Date end) throws ApartmentReserveException {
//        ReserveApartment reserve = new ReserveApartment(renter, start, end);
        ReserveApartment reserve = null;
        if (reserveBook.isEmpty()) {
            reserveBook.add(reserve);
            return;
        }
        for (ReserveApartment reserved : reserveBook) {

            if (reserved.getDateIN().after(start) && reserved.getDateOUT().after(end) ||
                    reserved.getDateOUT().before(start) && reserved.getDateOUT().before(end)) {
            } else {
                throw new ApartmentReserveException("Apartment is already reserved on this date");
            }
        }
        System.out.println("Reserve successful complete. Apartment id = " + apartmentID +
                "start date: " + start + ", end date: " + end + ".");
        reserveBook.add(reserve);
    }

    public void printReserveList() {
        for (ReserveApartment reserveApartm : reserveBook) {
            System.out.println(reserveApartm);
        }
    }

    public void addComment(String comment) {
        if (reviews == null) {
            reviews = new ArrayList<String>();
        }
        reviews.add(comment);
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public CityType getCity() {
        return city;
    }

    public void setCity(CityType city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Apartment{");
        sb.append("apartmentID=").append(apartmentID);
        sb.append(", hostID=").append(hostID);
        sb.append(", apartmentType=").append(apartmentType);
        sb.append(", city=").append(city);
        sb.append(", address='").append(address).append('\'');
        sb.append(", rooms=").append(rooms);
        sb.append(", accommodates=").append(accommodates);
        sb.append(", squareFootage=").append(squareFootage);
        sb.append('}');
        return sb.toString();
    }
}
