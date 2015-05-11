package com.morkva.entities;

import com.morkva.logic.Printer;

/**
 * Created by vladyslav on 02.05.15.
 */
public class Project extends Entity {

    private Category category;
    private String name;
    private String shortDescr;
    private int needMoney;
    private int currentMoney;
    private int daysLeft;
    private String history;
    private String urlVideo;
    private String[] questionsAndAnswers;
    private Printer printer;

    public Project(
            int id,
            String name,
            String shortDescr,
            int needMoney,
            int currentMoney,
            int daysLeft,
            String history,
            String urlVideo
    ) {
        super(id);
        this.name = name;
        this.shortDescr = shortDescr;
        this.needMoney = needMoney;
        this.currentMoney = currentMoney;
        this.daysLeft = daysLeft;
        this.history = history;
        this.urlVideo = urlVideo;
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

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void showFullInfo() {
        printer.print(this.getName() + "\n");
        printer.print("	Short Description: " + this.getShortDescr() + "\n");
        printer.print("	Need money: " + this.getNeedMoney() + "\n");
        printer.print("	Current money: " + this.getCurrentMoney() + "\n");
        printer.print("	Days left: " + this.getDaysLeft() + "\n");
        printer.print("	History: " + this.getHistory() + "\n");
        printer.print("	Video URL: " + this.getUrlVideo() + "\n");
    }

    public void showShortInfo() {
        printer.print(this.getName() + "\n");
        printer.print("	Short Description: " + this.getShortDescr() + "\n");
        printer.print("	Need money: " + this.getNeedMoney() + "\n");
        printer.print("	Current money: " + this.getCurrentMoney() + "\n");
        printer.print("	Days left: " + this.getDaysLeft() + "\n");
    }

}
