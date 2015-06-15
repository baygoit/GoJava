package com.morkva.entities;

import com.morkva.model.dao.Identified;
import com.morkva.utils.PaymentOption;

import java.util.Map;

/**
 * Created by vladyslav on 02.05.15.
 */
public class Project implements Identified<Integer> {

    private Integer id;
    private Category category;
    private String name;
    private String shortDescr;
    private int needMoney;
    private int currentMoney;
    private int daysLeft;
    private String history;
    private String urlVideo;
    private Map<Integer, PaymentOption> paymentOptions;

    public Project(
            String name,
            String shortDescr,
            int needMoney,
            int currentMoney,
            int daysLeft,
            String history,
            String urlVideo,
            Category category
    ) {
        this.name = name;
        this.shortDescr = shortDescr;
        this.needMoney = needMoney;
        this.currentMoney = currentMoney;
        this.daysLeft = daysLeft;
        this.history = history;
        this.urlVideo = urlVideo;
        this.category = category;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public int getNeedMoney() {
        return needMoney;
    }

    public void setNeedMoney(int needMoney) {
        this.needMoney = needMoney;
        if (getNeedMoney() < 0) {
            this.needMoney = 0;
        }
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getFullInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName()).append("\n");
        builder.append("	Short Description: ").append(this.getShortDescr()).append("\n");
        builder.append("	Need money: ").append(this.getNeedMoney()).append("\n");
        builder.append("	Current money: ").append(this.getCurrentMoney()).append("\n");
        builder.append("	Days left: ").append(this.getDaysLeft()).append("\n");
        builder.append("	History: ").append(this.getHistory()).append("\n");
        builder.append("	Video URL: ").append(this.getUrlVideo()).append("\n");
        return builder.toString();
    }

    public String getShortInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName() + "\n");
        builder.append("	Short Description: " + this.getShortDescr() + "\n");
        builder.append("	Need money: " + this.getNeedMoney() + "\n");
        builder.append("	Current money: " + this.getCurrentMoney() + "\n");
        builder.append("	Days left: " + this.getDaysLeft() + "\n");
        return builder.toString();
    }

    public Map<Integer, PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(Map<Integer, PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }


    @Override
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }
}
