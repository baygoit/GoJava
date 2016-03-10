package com.Homework3;

/**
 * Created by roman on 06.03.16.
 */
public class Progect {
    private String name;
    private int amount;
    private int days;
    private Category category;
    private String description;
    private int exist;
    private String history;
    private String demoVideo;
    private String questionAnswers;

    public Progect(String name, int amount, int days, String description, String demoVideo) {
        this.amount = amount;
        this.days = days;
        this.name = name;
        this.description = description;
        this.exist = 0;
        this.history = null;
        this.demoVideo = demoVideo;
        this.questionAnswers = null;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public int getExist() {
        return exist;
    }

    public int getDays() {
        return days;
    }
    public  void  setDemoVideo(String demoVideo) {
        this.demoVideo = demoVideo;
    }
    public void setQuestionAnswers(String questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public String getHistory() {
        return history;
    }

    public String getDemoVideo() {
        return demoVideo;
    }

    public String getQuestionAnswers() {
        return questionAnswers;
    }

}
