package com.gojava6.airbnb;

/**
 * Created by shata on 18.09.2015.
 */

public class Application {
    public static void main(String[] args) {
        AirBnB airbnb = new AirBnB();

        airbnb.register(UserBuilder.createClient("John", "Malkolm", "asd@asd.com"));
        airbnb.register(UserBuilder.createClient("Sam", "Morrison", "sam@gmail.com"));
        airbnb.register(UserBuilder.createHost("Dan", "Jamson", "qweqwe@gmail.com", "New-York", ApartType.APARTMENT));
        airbnb.register(UserBuilder.createHost("Jack", "Gray", "jack@gmail.com", "New-York", ApartType.ROOM));
        airbnb.register(UserBuilder.createClient("Tony", "Jackobson", "tony@gmail.com"));
        airbnb.register(UserBuilder.createHost("Nick", "Samuel", "nick@gmail.com", "Dallas", ApartType.PLACE));
    }
}