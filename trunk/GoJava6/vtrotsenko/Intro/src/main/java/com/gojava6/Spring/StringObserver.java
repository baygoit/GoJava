package com.gojava6.Spring;

/**
 * Created by root on 23.11.15.
 */
public class StringObserver implements Observer {

    private String message;

    public void update() {
        System.out.println("Message " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
