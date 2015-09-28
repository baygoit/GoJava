package com.Airbnb.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Airbnb airbnb = new Airbnb();

        airbnb.registerClient(new Client("Max", "Mad", "email@gmail.com"));
        airbnb.registerClient(new Client("Roman","Iovenko","email2@gmail.com"));
        airbnb.registerHost(new Host("Vova", "New", "email3@gmail.com", "Kyiv", ApartType.APARTMENT));
        airbnb.registerHost(new Host("Sasha","Prime","email4@gmail.com","Odessa", ApartType.ROOM));
        airbnb.notifyAll("Done");
        airbnb.removeClient(1);

    }
}
