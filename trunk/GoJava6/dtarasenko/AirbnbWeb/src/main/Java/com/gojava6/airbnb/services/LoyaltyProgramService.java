package com.gojava6.airbnb.services;

import com.gojava6.airbnb.dao.ISubscriberDao;
import com.gojava6.airbnb.model.Subscriber;
import com.gojava6.airbnb.model.User;
import com.gojava6.airbnb.observer.Observer;
import com.gojava6.airbnb.observer.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class LoyaltyProgramService implements Subject {

    private ISubscriberDao iSubscriberDao;
    private String loyaltyProgramName;
    private boolean available;

    public LoyaltyProgramService(ISubscriberDao iSubscriberDao) {
        this.iSubscriberDao = iSubscriberDao;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        if (available) {
            notifyObservers();
        }
    }

    public void setLoyaltyProgramName(String loyaltyProgramName) {
        this.loyaltyProgramName = loyaltyProgramName;
    }

    public void registerObserver(Observer observer) {
        User user = (User) observer;
        int userId = user.getUserId();

        Subscriber subscriber = new Subscriber();
        subscriber.setUserId(userId);

        iSubscriberDao.createSubscriber(subscriber);
    }

    public void removeObserver(Observer observer) {
        User user = (User) observer;
        int userId = user.getUserId();
        Subscriber subscriber = iSubscriberDao.getSubscriber(userId);
        iSubscriberDao.deleteSubscriber(subscriber);
    }

    public void notifyObservers() {
        System.out.println("\nNotifying all registered clients about new loyalty programs:");

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userService = (UserService) context.getBean("userService");

        List<Subscriber> subscriberList = iSubscriberDao.getSubscriberList();

        for (Subscriber subscriber : subscriberList) {
            int userId = subscriber.getUserId();
            User user = userService.getUser(userId);
            user.update(loyaltyProgramName);
        }
    }
}
