package com.gojava6.airbnb;

import com.gojava6.airbnb.model.apartment.CityType;

import com.gojava6.airbnb.model.user.User;
import com.gojava6.airbnb.model.user.UserType;

/**
 * @Autor Andrey Chaykin
 * @Since 09.11.2015
 */
public class Test {

    public static void main(String[] args) {


User user = new User(12, UserType.RENTER, "name", "surname", "mail");

        if(user.getUserType().equals(UserType.HOST)) {
            System.out.println("true, user is host");
        } else System.out.println("false, it is not so");


    }
}
