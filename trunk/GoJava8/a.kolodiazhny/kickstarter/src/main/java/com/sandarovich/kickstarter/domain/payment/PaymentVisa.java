package com.sandarovich.kickstarter.domain.payment;

/**
 * PaymentVisa
 */
public class PaymentVisa implements PaymentSystem {
    private int id;
    private long cardNumber;
    private String cardHolder;
    private double amount;

    @Override
    public boolean isPossible(double amount) {
        //TODO implement PaymentSystem system check
        return true;
    }

    @Override
    public boolean isProcess(double amount) {
        return amount > 0 && isPossible(amount);
    }
}
