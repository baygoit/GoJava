package com.tyomsky.kickstarter.model;

public class Project extends Entity {

    private String shortDescription;
    private int amountNeeded;
    private int amountCollected;
    private int daysLeft;
    private String history;
    private String videoURL;
    private QuestionsAndAnswers questionsAndAnswers;
    private Category category;

    public Project(int id, String name, String shortDescription,
                   int amountNeeded, int amountCollected, int daysLeft,
                   String history, String videoURL,
                   QuestionsAndAnswers questionsAndAnswers, Category category) {
        super(id, name);
        this.shortDescription = shortDescription;
        this.amountNeeded = amountNeeded;
        this.amountCollected = amountCollected;
        this.daysLeft = daysLeft;
        this.history = history;
        this.videoURL = videoURL;
        this.questionsAndAnswers = questionsAndAnswers;
        this.category = category;
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

    public void donate (int donation) {
        this.amountCollected += donation;
    }

}
