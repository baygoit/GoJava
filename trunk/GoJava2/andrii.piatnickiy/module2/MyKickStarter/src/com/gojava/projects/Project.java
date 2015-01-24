package com.gojava.projects;

public class Project {


    private String name;
    private String description;
    private int needSum;
    private int currentSum;
    private String daysLeft;
    private String projectHistory;
    private String linkOnvideo;
    private String questionsAndAnswers;
    private int categoryId;;

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

    public String getDaysLeft() {
        return daysLeft;
    }

    public Project(String name, String desc, int needSum, int currentSum,
            String daysLeft, int categoryId) {
        this.name = name;
        this.description = desc;
        this.needSum = needSum;
        this.currentSum = currentSum;
        this.daysLeft = daysLeft;
        this.categoryId = categoryId;
    }
}
