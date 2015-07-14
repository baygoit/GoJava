package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.mvc.view.ProjectView;

public class ProjectController {

    private ProjectModel model;
    private ProjectView view;

    public ProjectController(ProjectView view, ProjectModel model) {
        this.view = view;
        this.model = model;
    }

    public boolean showModel(int categoryIndex, int projectIndex) {
        boolean isShown = false;
        try {
            model.update(categoryIndex, projectIndex);
            view.show(model);
            isShown = true;
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            isShown = false;
        }
        return isShown;
    }

}
