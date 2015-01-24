package com.gojava.projects;

public class Project {

    public String getProjectHistory() {
        return projectHistory;
    }

    public void setProjectHistory(String projectHistory) {
        this.projectHistory = projectHistory;
    }

    public String getLinkOnvideo() {
        return linkOnvideo;
    }

    public void setLinkOnvideo(String linkOnvideo) {
        this.linkOnvideo = linkOnvideo;
    }

    public String getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(String questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private String name;
    private String description;
    private int needSum;
    private int currentSum;
    private int daysLeft;
    private String projectHistory;
    private String linkOnvideo;
    private String questionsAndAnswers;
    private int categoryId;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public int getNeedSum() {
        return needSum;
    }

    public int getCurrentSum() {
        return currentSum;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public Project(String name, String description, int needSum,
            int currentSum, int daysLeft, int categoryId) {
        this.name = name;
        this.description = description;
        this.needSum = needSum;
        this.currentSum = currentSum;
        this.daysLeft = daysLeft;
        this.categoryId = categoryId;
    }
}
