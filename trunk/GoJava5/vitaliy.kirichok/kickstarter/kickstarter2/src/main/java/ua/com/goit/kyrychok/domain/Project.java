package ua.com.goit.kyrychok.domain;

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
    private int id;

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
        faqs = new ArrayList<>();
        projectEvents = new ArrayList<>();
        rewards = new ArrayList<>();
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setFaqs(List<Faq> faqs) {
        this.faqs = faqs;
    }

    public void setProjectEvents(List<ProjectEvent> projectEvents) {
        this.projectEvents = projectEvents;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<ProjectEvent> getProjectEvents() {
        return projectEvents;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void addFaq(Faq faq) {
        faqs.add(faq);
    }

    public void addProjectEvent(ProjectEvent projectEvent) {
        projectEvents.add(projectEvent);
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }
}
