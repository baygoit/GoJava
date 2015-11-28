package com.gojava6.airbnb.user;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.apartment.CityType;

import java.util.ArrayList;
import java.util.List;

public class Host extends User {

    public Host(int hostID, String name, String surname, String eMail, CityType city) {
        super(hostID, name, surname, eMail, city);
    }

    public Host(int hostId, String name, String surname, String eMail, CityType city, List<Apartment> apartments) {
        super(hostId, name, surname, eMail, city, apartments);
    }
}
