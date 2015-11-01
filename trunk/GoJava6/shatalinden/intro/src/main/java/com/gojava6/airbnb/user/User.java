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

    private String name;
    private String surname;
    private String email;
    public UserType userType;
    private int userID = 0;

    public List<Apartment> apartments = new ArrayList<>();

    public User(String name, String surname, String email, int userType, int userID) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userID = userID;
        if (userType == 0) this.userType = UserType.CLIENT;
        else this.userType = UserType.HOST;
    }

    public User(String name, String surname, String email, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userType = userType;
    }

    public static User createUser(String name, String surname, String email, int userType, int userID) {
        return new User (name, surname, email, userType, userID);
    }

    public void becomeHost() {
            this.userType = UserType.HOST;
    }

    public Boolean getBooleanUserType() {
        if(this.userType == UserType.HOST) return true;
        else return false;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
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

    public User addApartments (Apartment apartment) {
        if (Validator.validateCity(apartment.city)) {
            if (this.getUserType() == UserType.HOST) {
                apartment.user = this;
//                apartment.apartmentID = ++this.apartmentID;
                apartments.add(apartment);
//                return apartment.city;
                return this;
            }
        }
        System.out.println("You can not add apartments to this user. Invalid user.");
//        return null;
        return this;
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
