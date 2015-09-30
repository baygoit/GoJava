package com.airbnb;

/**
 * Created by Игорь on 20.09.2015.
 */
public class Host extends User {
    private String city;

    public Host(String name, String surname, String email, String city) throws Exception {
        super(name, surname, email);
        if (Host.validateName(city) == true) {
            this.city = city;
        } else throw new Exception();
    }

    public String getCity() {
        return city;
    }

}
