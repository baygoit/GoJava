package com.gojava.projects;

public class ProjectStub  implements IProject{
    private String name;
    private String description;
    private int needSum;
    private int currentSum;
    private int daysLeft;
    private String projectHistory;
    private String linkOnvideo;
    private String questionsAndAnswers;
    private int categoryId;
    
    public ProjectStub() {
        this.name = "stubName";
        this.description = "stubDescription";
        this.needSum = 1;
        this.currentSum = 2;
        this.daysLeft = 3;
        this.projectHistory = "stubProjectHistory";
        this.linkOnvideo = "stublinkOnvideo";
        this.questionsAndAnswers = "stubQuestionsAndAnswers";
        this.categoryId = 0;
    }
    
    public String getName() {
        return name;
    }
    public String getDescription() {
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
    public String getProjectHistory() {
        return projectHistory;
    }
    public String getLinkOnvideo() {
        return linkOnvideo;
    }
    public String getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }
    public int getCategoryId() {
        return categoryId;
    }
}
