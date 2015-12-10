//package com.airbnb.services;
//
//import com.airbnb.dao.ISubscriberDao;
//import com.airbnb.model.User;
//import com.airbnb.model.Observer;
//import com.airbnb.observer.Subject;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Игорь on 21.09.2015.
// */
//public class NewsSubscribeService implements Subject {
//    private String news = "Your discounts 20%!";
//    private ISubscriberDao iSubscriberDao;
//
//    public NewsSubscribeService(ISubscriberDao iSubscriberDao) {
//        this.iSubscriberDao = iSubscriberDao;
//    }
//
//    public String getNews() {
//        return news;
//    }
//
//    public void setNews(String news) {
//        this.news = news;
//    }
//
//    public List<Observer> getObservers() {
//        return iSubscriberDao.getUserList();
//    }
//
//    @Override
//    public void registerObserver(Observer observer) {
//        iSubscriberDao.addToDb(observer);
//        System.out.println("Hello! You're subscribing on news");
//    }
//
//    @Override
//    public void removeObserver(int id) {
//        iSubscriberDao.delete(id);
//        System.out.println("Hello! You're unsubscribing on news");
//    }
//
//    @Override
//    public void notifyObservers() {
//        //System.out.println("Notyfying all registered customers; when product becomes available.");
//        List<Observer> observers = iSubscriberDao.getUserList();
//        for (Observer observer : observers) {
//            observer.update(news);
//        }
//    }
//
//    public void printObservers(){
//        List<Observer> observers = iSubscriberDao.getUserList();
//        for (Observer observer : observers) {
//            User user = (User) observer;
//            System.out.println(observer);
//        }
//    }
//}
