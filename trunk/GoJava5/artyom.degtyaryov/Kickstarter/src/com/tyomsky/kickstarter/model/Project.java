package com.tyomsky.kickstarter.model;

import java.util.List;

public class Project {

    private String name;
    private String shortDescription;
    private int amountNeeded;
    private int amountCollected;
    private int daysLeft;
    private String history;
    private String videoURL;
    private QuestionsAndAnswers questionsAndAnswers;
    private List<Event> events;

    public Project(String name, String shortDescription,
                   int amountNeeded, int amountCollected, int daysLeft,
                   String history, String videoURL,
                   QuestionsAndAnswers questionsAndAnswers) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.amountNeeded = amountNeeded;
        this.amountCollected = amountCollected;
        this.daysLeft = daysLeft;
        this.history = history;
        this.videoURL = videoURL;
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getAmountNeeded() {
        return amountNeeded;
    }

    public int getAmountCollected() {
        return amountCollected;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public String getHistory() {
        return history;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public QuestionsAndAnswers getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
