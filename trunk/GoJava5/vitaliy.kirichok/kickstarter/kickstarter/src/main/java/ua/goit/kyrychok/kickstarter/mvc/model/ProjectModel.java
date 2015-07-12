package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.Date;

public class ProjectModel {
    private DataProvider dataProvider;
    private Project project;

    public ProjectModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void update(int categoryIndex, int projectIndex) {
        this.project = dataProvider.getProject(categoryIndex, projectIndex);
    }

    public String getName() {
        return project.getName();
    }

    public String getShortDescription() {
        return project.getShortDescription();
    }

    public Integer getBalance() {
        return project.getBalance();
    }

    public Integer getGoal() {
        return project.getGoal();
    }

    public Date getDeadlineDate() {
        return project.getDeadlineDate();
    }

}
