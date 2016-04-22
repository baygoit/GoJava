package com.sandarovich.kickstarter.model;

public class Project {
    private long id;
    private String name;
    private String description;
    private double requiredBudget;
    private double gatheredBudget;
    private int daysLeft;
    private String videoLink;
    private String history;

    public Project() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRequiredBudget() {
        return requiredBudget;
    }

    public void setRequiredBudget(double requiredBudget) {
        this.requiredBudget = requiredBudget;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
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

    public double getGatheredBudget() {
        return gatheredBudget;
    }

    public void setGatheredBudget(double gatheredBudget) {
        this.gatheredBudget = gatheredBudget;
    }

}
