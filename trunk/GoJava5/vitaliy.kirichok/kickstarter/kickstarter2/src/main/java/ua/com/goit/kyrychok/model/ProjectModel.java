package ua.com.goit.kyrychok.model;

import java.util.List;

public class ProjectModel {
    public int id;
    public String name;
    public String shortDescription;
    public String goal;
    public String balance;
    public String timeLeft;
    public String demoLink;
    public List<FaqModel> faqs;
    public List<ProjectEventModel> projectEvents;
    public List<RewardModel> rewards;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getGoal() {
        return goal;
    }

    public String getBalance() {
        return balance;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public String getDemoLink() {
        return demoLink;
    }

    public List<FaqModel> getFaqs() {
        return faqs;
    }

    public List<ProjectEventModel> getProjectEvents() {
        return projectEvents;
    }

    public List<RewardModel> getRewards() {
        return rewards;
    }
}
