package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public class Host extends User {

    public ApartType type;

    public String city;

    public Host(String name, String surname, String email, String city, ApartType type) {
        super(name, surname, email);
        this.type = type;
        this.city = city;
    }

    public static Host hostConstructor(String name, String surname, String email, String city, ApartType type) {
        return new Host (name, surname, email, city, type);
    }

    public ApartType getType() {
        return type;
    }

    public String getCity() {
        return city;
    }
}
