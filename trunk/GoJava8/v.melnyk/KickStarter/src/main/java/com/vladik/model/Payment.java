package com.vladik.model;

public class Payment {
    private int projectID;
    private String cardholderName;
    private long cardNumber;
    private int donatingSum;

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getDonatingSum() {
        return donatingSum;
    }

    public void setDonatingSum(int donatingSum) {
        this.donatingSum = donatingSum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "projectID=" + projectID +
                ", cardholderName='" + cardholderName + '\'' +
                ", cardNumber=" + cardNumber +
                ", donatingSum=" + donatingSum +
                '}';
    }
}
