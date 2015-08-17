package com.tyomsky.kickstarter.model;

import java.util.Date;

public class Project {

    private int id;
    private String name;
    private String description;
    private int cost;
    private int balance;
    private String deadLine;
    private String videoLink;
    private String history;
    private String questionsAndAnswers;
    Category category;

    public int getCost() {
        return cost;
    }

    public int getBalance() {
        return balance;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Project(int id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(String questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

}
