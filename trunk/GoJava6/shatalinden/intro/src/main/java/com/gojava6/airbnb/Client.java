package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public class Client extends User{

    private Client(String name, String surname, String email) {
        super(name, surname, email);
    }
    public static User clientConstructor(String name, String surname, String email) {
        return new Client(name, surname, email);
    }
}
