package com.gojava6.airbnb;

/**
 * Created by Sergio on 18-Sep-15.
 */
public class Application {

    public static void main(String[] args) {
        ClientNotify notify = new ClientNotify();
        Observer one =  new Clients();
        Observer two = new Clients();
        notify.registerObserver(one);
        notify.registerObserver(two);
        notify.notifyObserver();

    }
}