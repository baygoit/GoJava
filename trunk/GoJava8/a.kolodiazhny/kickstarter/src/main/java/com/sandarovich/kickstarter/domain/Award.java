package com.sandarovich.kickstarter.domain;

/**
 * Award
 */
public class Award {
    private int id;
    private double amount;
    private String description;

    public Award(double ammount, String description) {
        this.amount = ammount;
        this.description = description;
    }

    public String getAward() {
        return amount + " $ -> " + description;
    }

    public double getAmount() {
        return amount;
    }


}
