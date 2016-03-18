package ua.dborisenko.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private String description;
    private String history;
    private int requiredSum;
    private int daysLeft;
    private String videoUrl;
    private List<Investment> investments = new ArrayList<Investment>();
    private List<Question> questions = new ArrayList<Question>();
    private List<Reward> rewards = new ArrayList<Reward>();

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

    public List<Reward> getRewards() {
        return rewards;
    }

    public void addReward(Reward reward) {
        this.rewards.add(reward);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    public Reward getRewardByIndex(int index) {
        return rewards.get(index);
    }
}
