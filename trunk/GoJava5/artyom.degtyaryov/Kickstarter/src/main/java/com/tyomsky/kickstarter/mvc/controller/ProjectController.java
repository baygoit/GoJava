package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.mvc.model.ProjectPageModel;
import com.tyomsky.kickstarter.mvc.view.ProjectPageView;

public class ProjectController extends AbstractController<ProjectPageModel, ProjectPageView> implements InputListener{

    public ProjectController(ProjectPageModel model, ProjectPageView view) {
        super(model, view);
    }

    @Override
    public void onInput(int... input) {
        if (!(input.length < 2)) {
            int categoryId = input[0];
            int projectId = input[1];
            model.update(categoryId, projectId);
        }
    }
}
