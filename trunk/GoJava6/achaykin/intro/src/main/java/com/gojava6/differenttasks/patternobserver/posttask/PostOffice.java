package com.gojava6.differenttasks.patternobserver.posttask;

import com.gojava6.differenttasks.patternobserver.Observer;
import com.gojava6.differenttasks.patternobserver.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 26.09.2015
 */
public class PostOffice implements Subject {

    List<Observer> observerList = new ArrayList<Observer>();
    private String address;
    private String text = "";

    public PostOffice(String adress) {
        this.address = adress;
    }

    public String getAddress(){
        return address;
    }

    public void sendMessage(String text) {
        this.text = text;
        notifyObservers();
    }

    public String getText() {
        return text;
    }

    public void addObserver(Observer o) {
        observerList.add(o);
    }

    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    public void notifyObservers() {

        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update();
        }
    }
}
