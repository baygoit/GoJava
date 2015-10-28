package com.gojava6.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio on 18-Sep-15.
 */
public class ClientNotify implements Subject {
    private List<Observer> clients = new ArrayList<Observer>();


    public void registerObserver(Observer o){
        clients.add(o);
    }
    public void removeObserver(Observer o){
        clients.remove(o);
    }
    public void notifyObserver(){
        for (Observer observer : clients ) {
            observer.update("Message");
        }

    }

    


}
