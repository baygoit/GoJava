package ua.goit.kyrychok.kickstarter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private String name;
    private String shortDescription;
    private int goal;
    private int balance;
    private Date createDate;
    private Date deadlineDate;
    private String demoLink;
    private List<Faq> faqs;
    private List<ProjectEvent> projectEvents;
    private List<Reward> rewards;

    public Project(String name, int goal, Date deadlineDate,
                   String shortDescription, int balance, String demoLink) {
        this(name, goal, deadlineDate);
        this.shortDescription = shortDescription;
        this.balance = balance;
        this.demoLink = demoLink;
    }

    public Project(String name, int goal, Date deadlineDate) {
        this.name = name;
        this.goal = goal;
        this.deadlineDate = deadlineDate;
        createDate = new Date();
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setDemoLink(String demoLink) {
        this.demoLink = demoLink;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getGoal() {
        return goal;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public String getDemoLink() {
        return demoLink;
    }

    public List<Faq> getFaqs() {
        return faqs;
    }

    public List<ProjectEvent> getProjectEvents() {
        return projectEvents;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void addFaq(Faq faq) {
        if (faqs == null) {
            faqs = new ArrayList<>();
        }
        faqs.add(faq);
    }

    public void addProjectEvent(ProjectEvent projectEvent) {
        if (projectEvents == null) {
            projectEvents = new ArrayList<>();
        }
        projectEvents.add(projectEvent);
    }

    public void addReward(Reward reward) {
        if (rewards == null) {
            rewards = new ArrayList<>();
        }
        rewards.add(reward);
    }
}
