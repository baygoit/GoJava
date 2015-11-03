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

    private String name;           // must be private
    private String surname;        // must be private
    private String email;          // must be private
    private String password;       // must be private
    public UserType userType;      // must be public now, but become private later
    private int userID = 0;        // must be private

    public List<Apartment> apartments = new ArrayList<>();

    public User(String name, String surname, String email, int userType, int userID, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userID = userID;
        this.password = password;
        if (userType == 0) this.userType = UserType.CLIENT;
        else this.userType = UserType.HOST;
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userType = UserType.CLIENT;
    }

    public static User createUser(String name, String surname, String email, int userType, int userID, String password) {
        return new User (name, surname, email, userType, userID, password);
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

    public String getType() {
        return this.userType.toString();
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

    public String getPassword() {
        return password;
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
