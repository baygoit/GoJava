package ua.goit.kyrychok.domain;

import java.util.Date;
import java.util.List;

public class Project {
    private String name;
    private String description;
    private String shortDescription;
    private Integer pledgeGoal;
    private Integer pledge;
    private Date createDate;
    private Date deadlineDate;
    private List<Faq> faqs;
    private List<ProjectEvent> projectEvents;

    public Project(String name, String description, String shortDescription, Integer pledgeGoal, Integer pledge, Date createDate, Date deadlineDate) {
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
        this.pledgeGoal = pledgeGoal;
        this.pledge = pledge;
        this.createDate = createDate;
        this.deadlineDate = deadlineDate;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPledgeGoal() {
        return pledgeGoal;
    }

    public Integer getPledge() {
        return pledge;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }
}
