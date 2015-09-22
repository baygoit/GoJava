package com.gojava6.observer.sportlife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergiigetman on 9/16/15.
 */
public class Sportlife implements Subject {

    private List<Observer> clients = new ArrayList<Observer>();

    public void register(Observer o) {
        clients.add(o);
    }

    public void remove(Observer o) {
        clients.remove(o);
    }

    public void notifyAllObservers() {
        for (Observer observer : clients) {
            observer.update("Discount");
        }

    }
}
