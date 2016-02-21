package com.kickstarter;

/**
 * Created by Игорь on 06.02.2016.
 */
public class Project {
    private String name;
    private int amount;
    private int days;
    private Category category;
    private String description;
    private int exist;
    private String history;
    private String demoVideo;
    private String quetionAnswer;

    public String getQuetionAnswer() {
        return quetionAnswer;
    }

    public void setQuetionAnswer(String quetionAnswer) {
        this.quetionAnswer = quetionAnswer;
    }

    public void setDemoVideo(String demoVideo) {
        this.demoVideo = demoVideo;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDays() {
        return days;
    }

    public String getDescription() {
        return description;
    }

    public Project(String name, int amount, int days, String description, String demoVideo) {
        this.name = name;
        this.amount = amount;
        this.days = days;
        this.description = description;
        this.exist = 0;
        this.demoVideo = demoVideo;
        this.history = null;
        this.quetionAnswer = null;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public int getExist() {
        return exist;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getDemoVideo() {

        return demoVideo;
    }

    public String getQuestionAnswers() {

        return quetionAnswer;
    }
}
