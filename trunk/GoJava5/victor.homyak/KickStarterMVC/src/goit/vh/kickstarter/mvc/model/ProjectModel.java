package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.model.Project;

import java.util.Date;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectModel {

    private DataRegistry dataRegistry;
    private Project[] listOfProjectses;
    private Project project;
    private String projectName;



    private String shortDescription;
    private int sumToRaise;
    private int currentSum;
    private Date endDate;
    private String projectHistory;
    private String fAQ;
    private String demoURL;

    public ProjectModel(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public Project[] getListOfProjectses() {
        return listOfProjectses;
    }

    public Object refreshModel(int[] path) {
        if (dataRegistry.getProject(path) == null) {
            return null;
        }
        project = dataRegistry.getProject(path);
        this.projectName = project.getName();
        this.shortDescription = project.getShortDescription();
        this.sumToRaise = project.getSumToRaise();
        this.currentSum = project.getCurrentSum();
        this.endDate = project.getEndDate();
        this.projectHistory = project.getProjectHistory();
        this.fAQ = project.getfAQ();
        this.demoURL = project.getDemoURL();
        return 1;
    }

    public Object refreshListModel(int input) {
        listOfProjectses = dataRegistry.getProjectList(input);
        if (dataRegistry.getProjectList(input) == null) {
            return null;
        }
        return 1;
    }
    public String getShortDescription() {
        return shortDescription;
    }

    public int getSumToRaise() {
        return sumToRaise;
    }

    public int getCurrentSum() {
        return currentSum;
    }

    public Date getEndDate() {
        return endDate;
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

    public String getProjectName() {
        return projectName;
    }


}

