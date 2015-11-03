package com.azuiev.model;

import com.azuiev.AirBnB;
import com.azuiev.enums.ApartType;
import com.azuiev.Validator;
import com.azuiev.service.UserService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lera on 23.09.2015.
 */
public class Apartment implements Comparable<Apartment> {
    private static Set<Apartment> apartments = new TreeSet<Apartment>();
    private static Set<String> cities = new TreeSet<String>();
    private User owner;
    private String city;
    private String address;
    private Integer id;

    private ApartType apartType;

    List<Reservation> reservations = new LinkedList<Reservation>();

    public Integer getId() {
        return id;
    }

    public static Apartment registerBook(User owner, String city, String address, ApartType apartType) {

        Apartment apartment = new Apartment(owner, city, address, apartType);

        Validator v = Validator.getInstance();

        if (!v.validateApartment(apartment)) {
            AirBnB.log.error("failed to create - " + apartment);
        } else {
            AirBnB.log.info("successfully created - " + apartment);
            if (apartments.add(apartment)) {
                AirBnB.log.info("added into listBooks - " + apartment);
            } else {
                AirBnB.log.error("already in listBooks - " + apartment);
            }
            if (!cities.contains(city)){
                cities.add(city);
                AirBnB.log.info("added new city - " + city);
                AirBnB.sportLife.cityAdded(city);

            }
            return apartment;
        }
        return null;
    }
    public Apartment(Integer id, Integer userId, String city, String address, ApartType apartType) {
        UserService userService = new UserService();
        this.owner = userService.getById(userId);
        this.city = city;
        this.address = address;
        this.apartType = apartType;
        this.id = id;
    }
    public Apartment(User owner, String city, String address, ApartType apartType) {
        this.owner = owner;
        this.city = city;
        this.address = address;
        this.apartType = apartType;
    }

    public static Set<Apartment> getApartments() {
        return apartments;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public ApartType getApartType() {
        return apartType;
    }

    public void setApartType(ApartType apartType) {
        this.apartType = apartType;
    }

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
        return city.compareTo(o.getCity()) * 100 + address.compareTo(o.getAddress());
    }

}
