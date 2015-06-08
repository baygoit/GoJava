package com.morkva.utils;

/**
 * Created by vladyslav on 29.05.15.
 */
public class PaymentOption {
    private String description;
    private Integer amount;

    public PaymentOption(String description, Integer amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }
}
