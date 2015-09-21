package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public class User {

    enum appartType{place, room, appartment}

    appartType type;
    private String name;
    private String surname;
    private String email;
    private String city;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public User(String name, String surname, String email, String city, appartType type) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.city = city;
        this.type = type;
    }

    public User() {
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

    public String getCity() {
        return city;
    }
}
