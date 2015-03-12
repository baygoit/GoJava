package model;

public class Project {
    private String name;
    private String description;
    private int needSum;
    private int currentSum;
    private int daysLeft;
    private String projectHistory;
    private String linkOnvideo;
    private String questionsAndAnswers;

//    public Project(String name, String description, int needSum, int currentSum, int daysLeft){
//        this.name = name;
//        this.description = description;
//        this.needSum = needSum;
//        this.currentSum = currentSum;
//        this.daysLeft = daysLeft;
//    }
    
    public Project(String name, String description, int needSum,
            int currentSum, int daysLeft, String projectHistory,
            String linkOnvideo, String questionsAndAnswers) {
        this.name = name;
        this.description = description;
        this.needSum = needSum;
        this.currentSum = currentSum;
        this.daysLeft = daysLeft;
        this.projectHistory = projectHistory;
        this.linkOnvideo = linkOnvideo;
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public void setCurrentSum(int currentSum) {
        this.currentSum = currentSum;
    }
    public String getName() {
        return name;
    }
    public void setQuestionsAndAnswers(String questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
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



}
