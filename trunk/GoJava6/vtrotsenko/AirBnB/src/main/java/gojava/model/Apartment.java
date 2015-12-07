package gojava.model;

import gojava.enums.ApartmentType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by root on 04.11.15.
 */
@Entity
@Table(name = "Apartment")
public class Apartment extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name="cityName")
    private String cityName;

    @Column(name = "apartmentType")
    private String sApartmentType;

    @Column(name = "begin")
    private LocalDate firstDayAvailable;

    @Column(name = "end")
    private LocalDate lastDayAvailable;

    @Transient
    private ApartmentType apartmentType;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Column(name = "hostId")
    private int hostId;

    public Apartment(ApartmentType apartmentType,
                     LocalDate firstDayAvailable, LocalDate lastDayAvailable) {

        this.isAvailable = true;
        this.apartmentType = apartmentType;
        this.sApartmentType = getsApartmentType();
        this.firstDayAvailable = firstDayAvailable;
        this.lastDayAvailable = lastDayAvailable;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    @Override
    public String toString() {
        return ("Apartment [id=" + this.getId() + ", city= " + this.getCityName() +
                ", apartmentType=" + this.getsApartmentType() + ", begin=" + this.getFirstDayAvailable() +
                ", end=" + this.getLastDayAvailable() + ", HostId= " + this.getHostId() +"]");
    }
}
