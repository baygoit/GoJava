package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Project;

public class ProjectModel {

    private DataProvider dataProvider;
    private Project project;

    public ProjectModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void update(int categoryIndex, int projectIndex) {
        project = dataProvider.getProject(categoryIndex, projectIndex);
    }

    public Project getProject() {
        return project;
    }
}
