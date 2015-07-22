package goit.vh.kickstarter.model;

import java.util.Date;

/**
 * Created by Viktor on 14.07.2015.
 */
public class Project {

    private String name;
    private String shortDescription;
    private int sumToRaise;
    private int currentSum;
    private Date endDate;
    private String projectHistory;
    private String fAQ;
    private String demoURL;
    
    public Project(String name, String shortDescription, int sumToRaise, int currentSum, Date endDate,
                   String projectHistory, String fAQ, String demoURL) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.sumToRaise = sumToRaise;
        this.currentSum = currentSum;
        this.endDate = endDate;
        this.projectHistory = projectHistory;
        this.fAQ = fAQ;
        this.demoURL = demoURL;
    }
    public String getShortDescription() {
        return shortDescription;
    }

    public String getName() {
        return name;
    }

    public int getSumToRaise() {
        return sumToRaise;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getCurrentSum() {
        return currentSum;
    }

    public String getProjectHistory() {
        return projectHistory;
    }

    public String getfAQ() {
        return fAQ;
    }

    public String getDemoURL() {
        return demoURL;
    }

}
