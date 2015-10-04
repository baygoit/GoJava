package com.gojava6.airbnb.user;

import com.gojava6.airbnb.validator.Validator;
import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.common.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shata on 17.09.2015.
 */
public class User implements Observer {

    public UserType userType;

    private String email;
    private String surname;
    private String name;
    private int apartmentID = 0;

    public List<Apartment> apartments = new ArrayList<>();

    public User(String name, String surname, String email, UserType userType) {
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.userType = userType;
    }

    public void becomeHost() {
            this.userType = UserType.HOST;
    }

    public UserType getUserType() {
        UserType type = userType;
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void update(String message) {
        System.out.println(message);
    }

    public String addApartments (Apartment apartment) {
        if (Validator.validateCity(apartment.city)) {
            if (this.getUserType() == UserType.HOST) {
                apartment.user = this;
                apartment.apartmentID = ++this.apartmentID;
                apartments.add(apartment);
                return apartment.city;
            }
        }
        System.out.println("You can not add apartments to this user. Invalid user.");
        return null;
    }

    public Apartment getApartmentByID (int id) {
        for (Apartment apartment : apartments) {
            if (apartment.apartmentID == id) return apartment;
        }
        return null;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }
}
