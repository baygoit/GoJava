package ua.dborisenko.kickstarter.domain;

import java.util.Set;

public class Project implements Comparable<Project> {

    private int id;
    private Category category;
    private String name;
    private String description;
    private String history;
    private int requiredSum;
    private int daysLeft;
    private String videoUrl;
    private Set<Investment> investments;
    private Set<Question> questions;
    private Set<Reward> rewards;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setRequiredSum(int requiredSum) {
        this.requiredSum = requiredSum;
    }

    public int getRequiredSum() {
        return requiredSum;
    }

    public int getCollectedSum() {
        int collectedSum = 0;
        for (Investment investment : investments) {
            collectedSum += investment.getAmount();
        }
        return collectedSum;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setVideoUrl(String videoURL) {
        this.videoUrl = videoURL;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Set<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(Set<Reward> rewards) {
        this.rewards = rewards;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int compareTo(Project project) {
        return this.name.compareTo(project.getName());
    }

}
