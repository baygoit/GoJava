package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.mvc.view.AbstractView;

public class ProjectController extends AbstractController{

    private ProjectModel model;

    public ProjectController(AbstractView view, ProjectModel model) {
        super(view);
        this.model = model;
    }

    @Override
    public void showModel(int... parameters) {
        if (parameters.length >= 2) {
            model.update(parameters[0]-1, parameters[1]-1);
            view.show(model);
        }
    }

    @Override
    public void processInput(int input) {
        if (input == 0) {
            AbstractController parent = getParent();
            parent.showModel(parent.getCurrentIndex());
            parent.setCurrentIndex(0);
        }
    }
}
