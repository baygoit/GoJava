package com.gojava6.airbnb;

/**
 * Created by shata on 17.09.2015.
 */
public abstract class User implements Observer{

    private String email;
    private String surname;
    private String name;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void update(String message) {
        System.out.println(message);
    }
}
