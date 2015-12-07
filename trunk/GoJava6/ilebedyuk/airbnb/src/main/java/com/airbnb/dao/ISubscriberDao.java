package com.airbnb.dao;

import com.airbnb.model.User;
import com.airbnb.model.Observer;

import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public interface ISubscriberDao {
    List<Observer> getUserList();
    Observer getUser(int id);
    void delete(int id);
    void addToDb(Observer observer);
}
