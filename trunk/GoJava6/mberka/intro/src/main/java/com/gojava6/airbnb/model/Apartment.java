package com.gojava6.airbnb.model;

import com.gojava6.observer.Validation;

import java.util.Date;

public class Apartment {
    private User user;
    private String apartmentCity;
    private Enum apartmentType;
    private String description;
    private Date startDate;
    private Date endDate;

    public Apartment(String apartmentCity, Enum apartmentType, String description,
                     Date startDate, Date endDate) {
        this.apartmentCity = apartmentCity;
        this.apartmentType = apartmentType;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getApartmentCity() {
        return apartmentCity;
    }

    public void setApartmentCity(String apartmentCity) {
        if (Validation.getValidation().validCityName(apartmentCity)) {
            this.apartmentCity = apartmentCity;
        }
    }

    public Enum getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(Enum apartmentType) {
        apartmentType = apartmentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
