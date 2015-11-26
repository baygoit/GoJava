package com.gojava6.airbnb;

import com.gojava6.airbnb.apartment.CityType;
import com.gojava6.airbnb.user.User;

/**
 * @Autor Andrey Chaykin
 * @Since 22.11.2015
 */
public class UtilUser {


    public static User createUser() {
        User user = new User("Xer", "petro", "sdsd@fdf.com", CityType.KIEV);
        return user;
    }

}
