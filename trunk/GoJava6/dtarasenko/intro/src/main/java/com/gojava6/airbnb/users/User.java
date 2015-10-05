package com.gojava6.airbnb.users;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {

    private static int userIdCounter;
    private int userId;
    private String name;
    private String surName;
    private String email;
    private UserType userType;
    private List<Apartment> apartmentList;


    public User() {
        userIdCounter += 1;
        this.userId =  userIdCounter;
        this.userType = UserType.CLIENT;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Apartment> getApartmentList() {
        return apartmentList;
    }

    public void becomeHost() {
        this.userType = UserType.HOST;
        this.apartmentList = new ArrayList<Apartment>();
        System.out.println(name + " became host");
    }

    public void addApartment(Apartment apartment) {
        if (userType.equals(UserType.HOST)) {
            apartmentList.add(apartment);
            System.out.println(name + " added apartment");
        } else {
            System.out.println("Only hosts can add apartments");
        }
    }

    @Override
    public void update(String loyaltyProgramName) {
        System.out.println(getName() + ", " + loyaltyProgramName + " is available for you!");
    }

}
