package com.airbnb.services;

import com.airbnb.observer.Observer;
import com.airbnb.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 21.09.2015.
 */
public class NewsSubscribe implements Subject {
    private String news = "Your discounts 20%!";
    private List<Observer> observers = new ArrayList<Observer>();

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Hello! You're subscribing on news");
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Hello! You're unsubscribing on news");

    }

    @Override
    public void notifyObservers() {
        //System.out.println("Notyfying all registered customers; when product becomes available.");
        for (Observer observer : observers) {
            observer.update(news);
        }

    }
}
