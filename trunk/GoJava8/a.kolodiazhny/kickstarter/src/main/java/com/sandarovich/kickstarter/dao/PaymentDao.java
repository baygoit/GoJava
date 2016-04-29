package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Payment;

public interface PaymentDao {
    void pay(Payment payment);
}
