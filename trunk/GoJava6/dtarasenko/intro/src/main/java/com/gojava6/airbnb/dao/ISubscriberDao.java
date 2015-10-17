package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.Subscriber;

import java.util.List;

public interface ISubscriberDao {

    void createSubscriber(Subscriber subscriber);
    void deleteSubscriber(Subscriber subscriber);
    List<Subscriber> getSubscriberList();
    Subscriber getSubscriber(Integer userId);

}
