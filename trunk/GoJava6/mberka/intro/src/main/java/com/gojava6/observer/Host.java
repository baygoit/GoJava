package com.gojava6.observer;

import java.util.*;

public class Host extends User {

    private String city;
    private String housingType;
    private List<String> listOfCities = new ArrayList<>();

    public enum HousingType {
        //TODO
        EntirePlace, PrivateRoom, SharedRoom;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        if (city.matches("[a-zA-Z]+")) {
            if (isModified(city)) {
                this.city = city;
                listOfCities.add(city);
            }
        }

    }

    public List<String> getListOfCities() {
        return listOfCities;
    }

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public boolean isModified (String city) {
        if (listOfCities.contains(city)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void update() {
    }
}
