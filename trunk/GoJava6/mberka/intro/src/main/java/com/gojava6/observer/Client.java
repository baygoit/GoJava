package com.gojava6.observer;

public class Client extends User {

    @Override
    public void update() {
        System.out.println("Hello, " + getUserName() + " " + getUserSurname() + "! "
                + "Since today application offers you a new city," +
                " where you can book a room.");

    }
}
