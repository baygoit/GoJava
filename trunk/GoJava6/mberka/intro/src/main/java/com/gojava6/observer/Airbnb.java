package com.gojava6.observer;

import java.util.ArrayList;
import java.util.List;

public class Airbnb implements ObservableSubject {

    private List<Observer> listOfObservers = new ArrayList<>();
    /*private Host host;
    private boolean isModified;*/

    public List<Observer> getListOfObservers() {
        return listOfObservers;
    }

    public void setListOfObservers(List<Observer> listOfObservers) {
        this.listOfObservers = listOfObservers;
    }

    @Override
    public void registerObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        /*if (host.addNewCity()) {*/
            for (Observer observer : listOfObservers) {
                observer.update();
            }
       /* }*/
    }



}

