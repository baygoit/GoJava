package ua.dborisenko.kickstarter.domain;

public class Project {
    private int id;
    private String name;
    private String description;
    private String history;
    private int requiredSum;
    private int collectedSum;
    private int daysLeft;
    private String videoUrl;
    private String discussionUrl;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return this.history;
    }

    public void setRequiredSum(int requiredSum) {
        this.requiredSum = requiredSum;
    }

    public int getRequiredSum() {
        return this.requiredSum;
    }

    public void setCollectedSum(int collectedSum) {
        this.collectedSum = collectedSum;
    }

    public int getCollectedSum() {
        return this.collectedSum;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return this.daysLeft;
    }

    public void setVideoUrl(String videoURL) {
        this.videoUrl = videoURL;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setDiscussionUrl(String discussionURL) {
        this.discussionUrl = discussionURL;
    }

    public String getDiscussionUrl() {
        return this.discussionUrl;
    }
}
