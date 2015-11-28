package com.gojava6.airbnb.user;

import com.gojava6.airbnb.Exception.UserValidationException;
import com.gojava6.airbnb.apartment.CityType;

/**
 * @Autor Andrey Chaykin
 * @Since 26.10.2015
 */
public class Renter extends User {

    public Renter(String name, String surname, String eMail, CityType city) throws UserValidationException{
        super(name, surname, eMail, city);
    }

    public Renter(int userId, String name, String surname, String eMail, CityType city) {
        super(userId, name, surname, eMail, city);
    }
}
