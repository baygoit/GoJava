package com.Airbnb.app;

import com.Airbnb.app.model.ApartType;
import com.Airbnb.app.model.Client;
import com.Airbnb.app.model.Host;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Airbnb airbnb = new Airbnb();

        airbnb.registerClient("Max", "Mad", "email@gmail.com");
        airbnb.registerClient("Roman","Iovenko","email2@gmail.com");
        airbnb.registerHost("Vova", "New", "email3@gmail.com");
        airbnb.registerHost("Sasha","Prime","email4@gmail.com");
        //airbnb.notifyAll("Done");
        airbnb.removeClient(1);

    }
}
