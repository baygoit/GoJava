package com.gojava6.Spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 23.11.15.
 */
public class TestSubject implements Subject {

    private List<Observer> observers;



    public void add(Observer... args) {
        observers.addAll(Arrays.asList(args));
    }

    public void remove() {
        System.out.println("Object removed");
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
}
