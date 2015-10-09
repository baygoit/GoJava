package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.IDao;
import com.gojava6.airbnb.dao.SubscriberDao;
import com.gojava6.airbnb.model.Subscriber;
import com.gojava6.airbnb.model.User;
import com.gojava6.airbnb.observer.Observer;
import com.gojava6.airbnb.observer.Subject;

import java.util.List;

public class LoyaltyProgramService implements Subject {

    private String loyaltyProgramName;
    private boolean available;

    public void setAvailable(boolean available) {
        this.available = available;
        if (available) {
            notifyObservers();
        }
    }

    public void setLoyaltyProgramName(String loyaltyProgramName) {
        this.loyaltyProgramName = loyaltyProgramName;
    }

    @Override
    public void registerObserver(Observer observer) {
        User user = (User) observer;
        int userId = user.getUserId();

        Subscriber subscriber = new Subscriber();
        subscriber.setUserId(userId);

        IDao iDao = new SubscriberDao();
        iDao.createObject(subscriber);
    }

    @Override
    public void removeObserver(Observer observer) {
        User user = (User) observer;
        int userId = user.getUserId();

        IDao iDao = new SubscriberDao();
        iDao.deleteObject(userId);
    }

    @Override
    public void notifyObservers() {
        System.out.println("\nNotifying all registered clients about new loyalty programs:");

        UserService userService = new UserService();

        IDao iDao = new SubscriberDao();
        List<Subscriber> subscriberList = (List<Subscriber>)(List<?>) iDao.getObjectList();

        for (Subscriber subscriber : subscriberList) {
            int subscriberId = subscriber.getUserId();
            User user = userService.getUser(subscriberId);
            user.update(loyaltyProgramName);
        }
    }
}
