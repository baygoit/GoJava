package com.gojava6.airbnb.apartment;

import com.gojava6.airbnb.data.Lists;
import com.gojava6.airbnb.user.User;
import com.gojava6.airbnb.reservation.ReservationDates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shata on 28.09.2015.
 */
public class Apartment {

    public ApartType type;
    public String city;
    public int apartmentID;
    public User user;
    public int userID;
    public int price;
    public String shortDescription;

    public List<ReservationDates> reservationDates = new ArrayList<>();

    public Apartment(int id, String city, String type, int userid, int price, String shortDescription) {
        this.apartmentID = id;
        this.city = city;
        setType(type);
        this.userID = userid;
        this.price = price;
        this.shortDescription = shortDescription;
    }

    public Apartment(String type, String city, int id, int userid) {
        this.city = city;
        this.apartmentID = id;
        setUser(userid);
        setType(type);
    }

    public Apartment(String type, String city, int id) {
        this.city = city;
        this.apartmentID = id;
        setType(type);
    }

    public Apartment(ApartType type, String city) {
        this.type = type;
        this.city = city;
    }

    public String getType() {
        return type.toString();
    }

    public String getCity() {
        return city;
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public int getUserID() {
        return userID;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUser(int userid) {
        for (User user : Lists.hostList) {
            if (user.getUserID()==userid) this.user = user;
        }
    }

    public void setType(String type) {
        if (type.equals("room")) this.type = ApartType.ROOM;
        if (type.equals("place")) this.type = ApartType.PLACE;
        if (type.equals("apartment")) this.type = ApartType.APARTMENT;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
