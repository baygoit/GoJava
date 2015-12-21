package com.gojava6.airbnb.model.user;


import com.gojava6.airbnb.Exception.UserValidationException;
import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.model.apartment.CityType;

import java.util.*;

import static com.gojava6.airbnb.validation.UserValidation.validationRenter;


public class User implements Observer {

    private int userId;
    private UserType userType;
    private String firstName;
    private String lastName;
    private String eMail;
    private CityType city;
//    private boolean isHost;
    private List<Apartment> apartments;

    public User(String firstName, String surname, String eMail) {
        try {
            if (validationRenter(firstName, surname, eMail)) {
                this.firstName = firstName;
                this.lastName = surname;
                this.eMail = eMail;
                userType = UserType.RENTER;
//                isHost = false;
            }
        } catch (UserValidationException e) {
            e.printStackTrace();
        }
    }

    public User(int userId, UserType userType, String name, String surname, String eMail) { //todo delete constr
        this.userId = userId;
        this.userType = userType;
        this.firstName = name;
        this.lastName = surname;
        this.eMail = eMail;
    }

    public User(int userId, UserType userType, String name, String surname, String eMail, CityType city) {
        this.userId = userId;
        this.userType = userType;
        this.firstName = name;
        this.lastName = surname;
        this.eMail = eMail;
        this.city = city;
    }

    public User(int userId, UserType userType, String name, String surname, String eMail, CityType city, List<Apartment> apartments) {
        this.userId = userId;
        this.userType = userType;
        this.firstName = name;
        this.lastName = surname;
        this.eMail = eMail;
        this.city = city;
        this.apartments = apartments;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public CityType getCity() {
        return city;
    }

    public void setCity(CityType city) {
        this.city = city;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public void addApartment(Apartment apartment) {
        if(apartments == null) {
            apartments = new ArrayList<>();
        }
        apartments.add(apartment); //todo validation
    }

    public Apartment getApartment(int apartmentID) {
        for(Apartment apartment : apartments) {
            if(apartment.getApartmentID() == apartmentID) {
                return apartment;
            }
        }
        return null;
    }

    public void update() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("ID=").append(userId);
        sb.append(", userType='").append(userType).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", eMail='").append(eMail).append('\'');
        sb.append(", city=").append(city);
//        sb.append(", isHost=").append(isHost);
        if(UserType.HOST.equals(userType) ) { //todo check
            sb.append(", apartments= " + apartments.size());
        }
        sb.append('}');
        return sb.toString();
    }
}
