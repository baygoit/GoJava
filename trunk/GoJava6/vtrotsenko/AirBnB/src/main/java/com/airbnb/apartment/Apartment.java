package com.airbnb.apartment;
import java.time.LocalDate;

/**
 * Created by root on 27.09.15.
 */
public class Apartment {

    private LocalDate firstDayAvailable;
    private LocalDate lastDayAvailable;
    private ApartmentType apartmentType;
    private boolean isAvailable = true;

    public Apartment() {}

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

    /*    the updateAvailableDate method logic:
     *          if date you want to book is later than firstDayAvailable
     *          the firstDayAvailable would be the same, but
     *          the lastDayAvailable woubld be the start of your reservation
     */


    public void updateAvailableDate(LocalDate start, LocalDate end) {

        // if end date is the same is last Day Available
        if (end.compareTo(lastDayAvailable) == 0) {
            isAvailable = false;
        }
        // if firstDayAvailable is earlier than start
        if (firstDayAvailable.compareTo(start) < 0) {
            isAvailable = true;
            lastDayAvailable = start;
        }
        // if end is earlier than last Day Available
        if (end.compareTo(lastDayAvailable) < 0) {
            isAvailable = true;
            firstDayAvailable = end;
        }
    }
}
