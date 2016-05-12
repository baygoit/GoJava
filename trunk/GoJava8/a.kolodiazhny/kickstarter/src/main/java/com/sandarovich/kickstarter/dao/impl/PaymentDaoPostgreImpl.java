package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.model.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PaymentDaoPostgreImpl implements PaymentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void pay(Payment payment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(payment);
        session.flush();
    }
}
