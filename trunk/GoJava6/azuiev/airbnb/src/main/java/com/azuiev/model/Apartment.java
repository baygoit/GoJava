package com.azuiev.model;

import com.azuiev.AirBnB;
import com.azuiev.enums.ApartType;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Masta on 23.09.2015.
 */

@Entity
@Table(name="apartment", catalog = "airbnb")
public class Apartment implements Comparable<Apartment> {
    private Long id;
    private String address;
    private ApartType apartType;
    private City city;
    private User owner;
    private List<Reservation> reservations = new ArrayList<Reservation>();

    //constructor
    public Apartment() {
    }

    public Apartment(String address, ApartType apartType, City city, User user) {

    }

    //getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="aparttype")
    public ApartType getApartType() {
        return apartType;
    }
    public void setApartType(ApartType apartType) {
        this.apartType = apartType;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "city", referencedColumnName = "id")
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", referencedColumnName = "id")
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Transient
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    //other methods
    public boolean reserveApartment(User user, Date start, Date end) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        if (!isFree(start, end)) {
            AirBnB.log.error("User - " + this + "can`t reserve apartment in period {" + dateFormat.format(start) + ":" + dateFormat.format(end));
            return false;
        }

        reservations.add(new Reservation(user, start, end));
        AirBnB.log.info("User " + user + "successfully reserved - " + this + " in period {" + dateFormat.format(start) + ":" + dateFormat.format(end));
        return true;
    }

    public boolean isFree(Date start, Date end) {
        Date date1, date2;
        for (Reservation reservation : reservations) {
            date1 = reservation.getBegin();
            date2 = reservation.getEnd();
            if (end.compareTo(date1) <= 0) {
                continue;
            }

            if (start.compareTo(date2) >= 0) {
                continue;
            }
            return false;

        }
        return true;
    }

    @Override
    public int compareTo(Apartment o) {
        return city.getName().compareTo(o.getCity().getName()) * 100 + address.compareTo(o.getAddress());
    }
}
