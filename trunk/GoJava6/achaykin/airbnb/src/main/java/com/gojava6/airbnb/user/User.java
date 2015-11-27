package com.gojava6.airbnb.user;


import com.gojava6.airbnb.Exception.UserValidationException;
import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.CityType;

import javax.persistence.*;
import java.util.*;

import static com.gojava6.airbnb.validation.UserValidation.validationRenter;

@Entity
@Table(name = "user")
public class User implements Observer {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "userID", length = 10, nullable = false)
    private int userId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "eMail")
    private String eMail;
    @Enumerated(EnumType.STRING)
    private CityType city;
    @Column(name = "is_host")
    private boolean isHost;
    private List<Apartment> apartments;

    public User(String name, String surname, String eMail, CityType city) {
        try {
            if (validationRenter(name, surname, eMail)) {
                this.firstName = name;
                this.lastName = surname;
                this.eMail = eMail;
                this.city = city;
                isHost = false;
            }
        } catch (UserValidationException e) {
            e.printStackTrace();
        }
    }

    public User(int userId, String name, String surname, String eMail, CityType city) {
        this.userId = userId;
        this.firstName = name;
        this.lastName = surname;
        this.eMail = eMail;
        this.city = city;
        isHost = false;
    }

    public User(int userId, String name, String surname, String eMail, CityType city, List<Apartment> apartments) {
        this.userId = userId;
        this.firstName = name;
        this.lastName = surname;
        this.eMail = eMail;
        this.city = city;
        this.apartments = apartments;
        isHost = true;
    }

    public static void becomeHost(User user) {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public boolean getIsHost() {
        return isHost;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public void addApartment(Apartment apartment) {
        if(apartments == null) {
            apartments = new ArrayList<Apartment>();
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
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", eMail='").append(eMail).append('\'');
        sb.append(", city=").append(city);
        sb.append(", isHost=").append(isHost);
        if(isHost) {
            sb.append(", apartments= " + apartments.size());
        }
        sb.append('}');
        return sb.toString();
    }
}
