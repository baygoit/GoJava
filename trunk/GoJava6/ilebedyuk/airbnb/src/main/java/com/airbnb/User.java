package com.airbnb;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by Игорь on 20.09.2015.
 */
public abstract class User implements Observer{
    private String Name;
    private String Surname;
    private String Email;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("Hello!" + getName() + ", today next news: " + news);
    }
}