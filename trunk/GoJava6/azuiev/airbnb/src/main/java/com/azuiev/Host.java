package com.azuiev;

/**
 * Created by Lera on 21.09.2015.
 */
public class Host extends User{
    String city;
    ApartType apartmentType;
    public Host(String name, String surName, String email, String city, ApartType type) {

        this.name = name;
        this.surName = surName;
        this.email = email;
        this.city = city;
        this.apartmentType = type;
    }
    public void notifyObserver(String s) {
        System.out.println(s);
    }
}
