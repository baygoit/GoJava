package com.gojava6.Spring;

/**
 * Created by root on 23.11.15.
 */
public class CustomObserver implements Observer {

    private Observer observer;

    public CustomObserver(Observer observer) {
        this.observer = observer;
    }

    public void update() {
        observer.update();
    }
}
