package com.gojava6.airbnb;

/**
 * Created by shata on 18.09.2015.
 */

public class Application {
    public static void main(String[] args) {
        AirBnB airbnb = new AirBnB();

        airbnb.register(UserBuilder.createClient("John", "Malkolm", "asd@asd.com"));
        airbnb.register(UserBuilder.createClient("Sam", "Morrison", "sam@gmail.com"));
        airbnb.register(UserBuilder.createHost("Dan", "Jamson", "qweqwe@gmail.com", "New-York", User.appartType.appartment));
        airbnb.register(UserBuilder.createHost("Jack", "Gray", "jack@gmail.com", "New-York", User.appartType.room));
        airbnb.register(UserBuilder.createHost("Nick", "Samuel", "nick@gmail.com", "Dallas", User.appartType.place));

//        airbnb.notifyUsers();
    }
}