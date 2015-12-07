package com.airbnb.model;

import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * Created by Игорь on 26.09.2015.
 */
@Entity
@Table(name="apartament")
public class Apartment {

    @Column(name = "type")
    private String apartmentType;
    @Column
    private String city;

    @Column(name = "iduser")
    private int ownerId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idaparnaments")
    private int idAparnament;

    private static final Logger log = Logger.getLogger(Apartment.class);

    public Apartment(){}

    public Apartment(String apartmentType, String city, int ownerId) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.ownerId = ownerId;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public String getCity() {
        return city;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public int getIdAparnament() {
        return idAparnament;
    }

    public void setIdAparnament(int idAparnament) {
        this.idAparnament = idAparnament;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return "Id: '" + this.idAparnament +
                "', Apartament type: '" + this.apartmentType +
                "', City: '" + this.city +
                "', Owner id: '" + this.ownerId + "'";
    }
}
