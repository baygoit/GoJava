package com.azuiev.Users;

/**
 * Created by Lera on 21.09.2015.
 */
public class Host extends User {

    public Host(String name, String surName, String email) {
        super(name, surName, email);
    }

    public void notifyObserver(String s) {
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "host = {" + super.toString()+"}";
    }


}
