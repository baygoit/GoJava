package com.Airbnb.app.model;

import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Host;
import com.Airbnb.app.validation.Validator;

/**
 * Created by romanroma on 28.09.15.
 */
public class Apartment {
    private static int APARTMENT_ID = 0;
    private int id;
    private User host;
    private String city;
    private ApartType apartType;
    private boolean reserved;

    public Apartment(User host, String city, ApartType apartType, boolean reserved){
        this.id = ++APARTMENT_ID;
        this.host = host;
        this.city= city;
        this.apartType = apartType;
        this.reserved = reserved;
    }

    public int getId (){
        return id;
    }

    public User getHost (){
        return host;
    }

    public void setHost (User host){
        this.host = host;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public ApartType getApartType () {
        return apartType;
    }

    public void setApartType (ApartType apartType){
        this.apartType = apartType;
    }

    public boolean isReserved(){
        return reserved;
    }

    public void setReserved (Boolean reserved){
        this.reserved = reserved;
    }

    public boolean validation (){
        return Validator.validateUserCity(city);
    }
}
