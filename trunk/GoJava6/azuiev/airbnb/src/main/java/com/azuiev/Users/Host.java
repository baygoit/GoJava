package com.azuiev.Users;

import com.azuiev.App;
import com.azuiev.Books.ApartType;
import com.azuiev.Books.Book;
import com.azuiev.Organization.Organization;

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

    public Book createBook(String city, String address, ApartType apartType){
        return Book.registerBook(this, city, address, apartType);

    }



}
