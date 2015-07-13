package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Project;

public class ProjectModel extends AbstractModel {

    private Project project;

    public ProjectModel(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    public void update(int... parameters) {
        if (parameters.length >=2) {
            project = dataProvider.getProject(parameters[0], parameters[1]);
        }
    }

    public Project getProject() {
        return project;
    }
}
