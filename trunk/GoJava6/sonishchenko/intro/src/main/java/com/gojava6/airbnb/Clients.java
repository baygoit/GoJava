package com.gojava6.airbnb;



/**
 * Created by Sergio on 18-Sep-15.
 */
public class Clients implements Observer {

    public void update(String message) {
        System.out.println(message);
    }
}
