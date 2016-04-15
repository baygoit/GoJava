package com.vladik.model;

import java.util.*;

public class Project {
    private int id;
    private int categoryID;
    private String title;
    private String briefDescription;
    private String fullDescription;
    private String videoLink;
    private int requiredSum;
    private int daysLeft;
    private int collectedSum;
    private List<Payment> paymentList = new ArrayList<Payment>();
    private List<Faq> faqList = new ArrayList<Faq>();
    private List<Reward> rewardList = new ArrayList<Reward>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getRequiredSum() {
        return requiredSum;
    }

    public void setRequiredSum(int requiredSum) {
        this.requiredSum = requiredSum;
    }

    public int getCollectedSum() {
        int collectedSum = 0;
        for (Payment payment : paymentList) {
            collectedSum += payment.getDonatingSum();
        }
        return collectedSum;
    }

    public void setCollectedSum(int someMoney) {
        this.collectedSum += someMoney;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public void setDeadline(int day, int month, int year) {
        daysLeft = getDaysLeft(day, month, year);
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public List<Faq> getFaqList() {
        return faqList;
    }

    public void setFaqList(List<Faq> faqList) {
        this.faqList = faqList;
    }

    public void addFaq(Faq faq) {
        faqList.add(faq);
    }

    public List<Reward> getRewardList() {
        return rewardList;
    }

    public void setRewardList(List<Reward> rewardList) {
        this.rewardList = rewardList;
    }
    public void addReward(Reward reward) {
        rewardList.add(reward);
    }


    protected int getDaysLeft(int day, int month, int year) {
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
        Calendar currentCalendar = Calendar.getInstance();
        Date date = new Date();

        currentCalendar.setTimeZone(timeZone);
        currentCalendar.setTime(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Math.abs(month - 1));

        long difference = calendar.getTimeInMillis() - currentCalendar.getTimeInMillis();
        long days = difference / (1000 * 60 * 60 * 24);

        return (int) days;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", categoryID=" + categoryID +
                ", title='" + title + '\'' +
                ", briefDescription='" + briefDescription + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", requiredSum=" + requiredSum +
                ", collectedSum=" + collectedSum +
                ", daysLeft=" + daysLeft +
                '}';
    }
}
