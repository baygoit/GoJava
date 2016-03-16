package com.goit.file;

import java.util.Locale;

/**
 * Created by roman on 13.03.16.
 */
public class Progect {
    private  Integer nubberProject;
    private String name;
    private int amount;
    private int days;
    private Locale.Category category;
    private String description;
    private int exist;
    private String history;
    private String demoVideo;
    private String questionAnswers;

    /*public Progect(String name, int amount, int days, Locale.Category category, String description, int exist, String history, String demoVideo, String questionAnswers) {
        this.name = name;
        this.amount = amount;
        this.days = days;
        this.category = category;
        this.description = description;
        this.exist = 0;
        this.history = null;
        this.demoVideo = demoVideo;
        this.questionAnswers = null;
    }*/
    public int getNubberProject() {
        return nubberProject;
    }

    public void setNubberProject(int nubberProject) {
        this.nubberProject = nubberProject;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(String questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public String getDemoVideo() {
        return demoVideo;
    }

    public void setDemoVideo(String demoVideo) {
        this.demoVideo = demoVideo;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Locale.Category getCategory() {
        return category;
    }

    public void setCategory(Locale.Category category) {
        this.category = category;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



}
