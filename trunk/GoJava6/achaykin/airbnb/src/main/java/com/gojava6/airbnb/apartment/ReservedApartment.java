package com.gojava6.airbnb.apartment;

import java.util.Date;

public class ReservedApartment {

    private int resereveID; //todo dont forget put into table
    private int apartmentID;
    private int hostID;
    private int renterID;
    private Date dateIN;
    private Date dateOUT;

    public ReservedApartment(int apartmentID, int hostID, int renterID, Date dateIN, Date dateOUT){
        this.apartmentID = apartmentID;
        this.hostID = hostID;
        this.renterID = renterID;
        this.dateIN = dateIN;
        this.dateOUT = dateOUT;
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public int getRenterID() {
        return renterID;
    }

    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    public Date getDateIN() {
        return dateIN;
    }

    public void setDateIN(Date dateIN) {
        this.dateIN = dateIN;
    }

    public Date getDateOUT() {
        return dateOUT;
    }

    public void setDateOUT(Date dateOUT) {
        this.dateOUT = dateOUT;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReservedApartment{");
        sb.append("resereveID=").append(resereveID);
        sb.append(", apartmentID=").append(apartmentID);
        sb.append(", hostID=").append(hostID);
        sb.append(", renterID=").append(renterID);
        sb.append(", dateIN=").append(dateIN);
        sb.append(", dateOUT=").append(dateOUT);
        sb.append('}');
        return sb.toString();
    }
}
