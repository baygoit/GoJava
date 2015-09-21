package com.gojava6.observer.project;

/**
 * Created by slavik on 21.09.2015.
 */
class Client extends User {
    private String city;
    Client(String name, String surname, String email, String city ) {
        super(name, surname, email);
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
