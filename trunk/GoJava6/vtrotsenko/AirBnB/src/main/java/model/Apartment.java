package model;

import enums.ApartmentType;

import java.time.LocalDate;

/**
 * Created by root on 04.11.15.
 */
public class Apartment extends Entity{
    private LocalDate firstDayAvailable;
    private LocalDate lastDayAvailable;
    private ApartmentType apartmentType;
    private String sApartmentType;
    private boolean isAvailable;
    private int hostId;

    public Apartment(int id, ApartmentType apartmentType,
                     LocalDate firstDayAvailable, LocalDate lastDayAvailable, int hostId) {
        super(id);
        this.isAvailable = true;
        this.apartmentType = apartmentType;
        this.sApartmentType = getsApartmentType();
        this.firstDayAvailable = firstDayAvailable;
        this.lastDayAvailable = lastDayAvailable;
        this.hostId = hostId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public LocalDate getFirstDayAvailable() {
        return firstDayAvailable;
    }

    public void setFirstDayAvailable(LocalDate firstDayAvailable) {
        this.firstDayAvailable = firstDayAvailable;
    }

    public LocalDate getLastDayAvailable() {
        return lastDayAvailable;
    }

    public void setLastDayAvailable(LocalDate lastDayAvailable) {
        this.lastDayAvailable = lastDayAvailable;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getsApartmentType() {
        if (this.apartmentType == ApartmentType.APARTMENT)
            this.sApartmentType = "APARTMENT";
        else if (this.apartmentType == ApartmentType.PLACE)
            this.sApartmentType = "PLACE";
        else if (this.apartmentType == ApartmentType.ROOM)
            this.sApartmentType = "ROOM";
        return sApartmentType;
    }

    public void setsApartmentType(String sApartmentType) {
        this.sApartmentType = sApartmentType;
    }


    public void updateAvailableDate(LocalDate start, LocalDate end) {

        if (end.compareTo(lastDayAvailable) == 0) {
            isAvailable = false;
        }

        if (firstDayAvailable.compareTo(start) < 0) {
            isAvailable = true;
            lastDayAvailable = start;
        }

        if (end.compareTo(lastDayAvailable) < 0) {
            isAvailable = true;
            firstDayAvailable = end;
        }
    }
}
