package com.Airbnb.app.model;

import com.Airbnb.app.validation.Validator;

/**
 * Created by romanroma on 28.09.15.
 */
public class Apartment {
    private static int APARTMENT_ID = 0;
    private int id;
    private int hostId;
    private String city;
    private ApartType apartType;

    public Apartment(int hostId, String city, ApartType apartType){
        this.id = ++APARTMENT_ID;
        this.hostId = hostId;
        this.city = city;
        this.apartType= apartType;
    }

    public int getId (){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getHost (){
        return hostId;
    }

    public void setHost (int hostId){
        this.hostId = hostId;
    }

    public String getCity(){
        return city;
    }

    public void setCity (String city){
        this.city = city;
    }

    public ApartType getApartType () {
        return apartType;
    }

    public void setApartType (ApartType apartType){
        this.apartType = apartType;
    }

    public boolean validation (){
        return Validator.validateUserCity(city);
    }
}
