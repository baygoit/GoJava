package com.gojava6.airbnb;

/**
 * Created by shata on 28.09.2015.
 */
public class Apartment {

    public ApartType type;
    Host host;

    public Apartment(ApartType type) {
        this.type = type;
    }

    public String getType() {
        return type.toString();
    }
}
