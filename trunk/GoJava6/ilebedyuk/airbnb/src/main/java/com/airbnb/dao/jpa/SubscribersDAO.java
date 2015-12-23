package com.airbnb.dao.jpa;

import com.airbnb.dao.ISubscriberDao;
import com.airbnb.model.Observer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 14.11.2015.
 */
@Component
public class SubscribersDAO implements ISubscriberDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Observer> getUserList() {
        List<Observer> observers = em.createQuery("select o from Observer o").getResultList();
        return observers;
    }

    @Override
    @Transactional
    public Observer getUser(int id) {
        Observer observer = em.find(Observer.class, id);
        return observer;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Observer observer = em.find(Observer.class, id);
        em.remove(observer);
    }

    @Override
    @Transactional
    public void addToDb(Observer observer) {
        em.persist(observer);
    }
}
