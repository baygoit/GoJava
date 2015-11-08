package com.airbnb.model;

import org.apache.log4j.Logger;

/**
 * Created by Игорь on 20.09.2015.
 */
public class User implements com.airbnb.observer.Observer {
    private String Name;
    private String Surname;
    private String Email;
    private int userId;
    private String userType;
    private String city;
    private static final Logger log = Logger.getLogger(User.class);

    public User() {}

    public User(String name, String surname, String email, String city, String userType) {
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.userType = userType;
        this.city = city;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname){
        Surname = surname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserType() {
        return userType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return Name;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public void update(String news) {
        System.out.println("Hello! " + Name + ", today next news: " + news);
    }

    @Override
    public String toString() {
        return "Id: '" + this.userId +
                "', Name: '" + this.Name +
                "', Surname: '" + this.Surname +
                "', Email: '" + this.Email +
                "', City: '" + this.city +
                "', UserType: '" + this.userType + "'";
    }

}