package com.sandarovich.kickstarter.dto;

public class PaymentDto {

    private double amount;
    private String cardHolder;
    private String cardNumber;
    private long projectId;
    private long awardId;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getAwardId() {
        return awardId;
    }

    public void setAwardId(long awardId) {
        this.awardId = awardId;
    }
}
