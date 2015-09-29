package com.Airbnb.app;

/**
 * Created by romanroma on 26.09.15.
 */
public class Host extends User {

    private String city;
    private ApartType apartmentType;

    public Host(String name, String surname, String email, String city, ApartType apartmentType){
        super(name, surname, email);
        this.city = city;
        this.apartmentType = apartmentType;
    }

    public String getCity(){
        return city;
    }

    public ApartType getApartmentType(){
        return apartmentType;
    }

    @Override
    public boolean validation(){
        return super.validation() && Validator.validateUserCity(city);
    }

}
