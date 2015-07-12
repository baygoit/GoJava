package ua.goit.kyrychok.kickstarter.model;

import java.util.Date;
import java.util.List;

public class Project {
    private String name;
    private String description;
    private String shortDescription;
    private Integer goal;
    private Integer balance;
    private Date createDate;
    private Date deadlineDate;
    private List<Faq> faqs;
    private List<ProjectEvent> projectEvents;

    public Project(String name, String description, String shortDescription, Integer goal, Integer balance, Date createDate, Date deadlineDate) {
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
        this.goal = goal;
        this.balance = balance;
        this.createDate = createDate;
        this.deadlineDate = deadlineDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Integer getGoal() {
        return goal;
    }

    public Integer getBalance() {
        return balance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public List<Faq> getFaqs() {
        return faqs;
    }

    public List<ProjectEvent> getProjectEvents() {
        return projectEvents;
    }
}
