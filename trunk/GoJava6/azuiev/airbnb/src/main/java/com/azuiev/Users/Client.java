package com.azuiev.Users;


/**
 * Created by Lera on 21.09.2015.
 */
public class Client extends User {


    public Client(String name, String surName, String email) {
        super(name, surName, email);
    }

    @Override
    public String toString() {
        return "Client = {" + super.toString() + "}";
    }

    public void notifyObserver(String s) {
        System.out.println(s);
    }

}
