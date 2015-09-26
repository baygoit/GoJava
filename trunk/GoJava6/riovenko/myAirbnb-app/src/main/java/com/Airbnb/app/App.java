package com.Airbnb.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Airbnb airbnb = new Airbnb();

        airbnb.registerClient(new Client("Max", "Mad", "1"));
        airbnb.registerClient(new Client("Roman","Iovenko","2"));
        airbnb.registerHost(new Host("Vova","New","123","Kyiv", ApartType.APARTMENT));
        airbnb.registerHost(new Host("Sasha","Prime","564","Odessa", ApartType.ROOM));

    }
}
