package ua.goit.kyrychok.kickstarter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private String name;
    private String shortDescription;
    private Integer goal;
    private Integer balance;
    private Date createDate;
    private Date deadlineDate;
    private String demoLink;
    private List<Faq> faqs;
    private List<ProjectEvent> projectEvents;

    public Project(String name, String shortDescription, Integer goal, Integer balance, Date createDate, Date deadlineDate, String demoLink) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.goal = goal;
        this.balance = balance;
        this.createDate = createDate;
        this.deadlineDate = deadlineDate;
        this.demoLink = demoLink;
    }

    public String getName() {
        return name;
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
}
