package model;

import observer.Observer;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class User implements Observer, Serializable{
    private int id;
    private String name;
    private String lastName;
    private GenderType gender;
    private Date birthDate;
    private String email;
    private CityList city;
    private String country;
    private HashMap<Integer, User> users;

    public User() {
    }

    public User(int id, String name, String lastName, GenderType gender, Date birthDate, String email, CityList city) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(CityList city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public GenderType getGender() {
        return gender;
    }



    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public CityList getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Integer, User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public void notifyObserver(String s) {

    }
}
