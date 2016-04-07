package com.sandarovich.kickstarter.domain.payment;

/**
 * PaymentSystem interface
 */

public interface PaymentSystem {
    boolean isPossible(double amount);
    boolean isProcess(double amount);
}
