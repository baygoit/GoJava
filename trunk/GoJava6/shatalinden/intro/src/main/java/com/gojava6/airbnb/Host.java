package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public class Host extends User{

    private Host(String name, String surname, String email, String city, appartType type) {
        super(name, surname, email, city, type);
    }
    public static User hostConstructor(String name, String surname, String email, String city, appartType type) {
        return new Host(name, surname, email, city, type);
    }
}
