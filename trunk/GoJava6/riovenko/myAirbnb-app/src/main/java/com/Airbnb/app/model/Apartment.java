package com.Airbnb.app.model;

import com.Airbnb.app.validation.Validator;

/**
 * Created by romanroma on 28.09.15.
 */
public class Apartment {
    private static int APARTMENT_ID = 0;
    private int id;
    private int hostId;
    private int cityId;
    private ApartType apartType;

    public Apartment(int hostId, int cityId, ApartType apartType){
        this.id = ++APARTMENT_ID;
        this.hostId = hostId;
        this.cityId = cityId;
        this.apartType = apartType;
    }

    public int getId (){
        return id;
    }

    public int getHost (){
        return hostId;
    }

    public void setHost (int hostId){
        this.hostId = hostId;
    }

    public int getCity(){
        return cityId;
    }

    public void setCity (int city){
        this.cityId = cityId;
    }

    public ApartType getApartType () {
        return apartType;
    }

    public int getApartTypeId (ApartType apartType){
        return apartType.getId(apartType);
    }

    public void setApartType (ApartType apartType){
        this.apartType = apartType;
    }

    public boolean validation (){
        //return Validator.validateUserCity(city);
        return true;
    }
}
