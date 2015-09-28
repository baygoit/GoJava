package com.observer.sportlife;

/**
 * Created by sergiigetman on 9/16/15.
 */
public class Client implements Observer {
    public void update(String message) {
        System.out.println(message);
    }
}
