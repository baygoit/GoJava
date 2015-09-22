package com.azuiev;


/**
 * Created by Lera on 21.09.2015.
 */
public class Client extends User {

    public Client(String name, String surName, String email) {

        this.name = name;
        this.surName = surName;
        this.email = email;

    }

    public void notifyObserver(String s) {
        System.out.println(s);
    }
}
