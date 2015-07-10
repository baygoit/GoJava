package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.model.ProjectModel;
import com.tyomsky.kickstarter.ui.Output;

public class ProjectView extends AbstractView  {

    private ProjectModel model;

    public ProjectView(ProjectModel model, Output output) {
        super(output);
        this.model = model;
    }

    @Override
    protected void prepareLayout() {
        layout.clear();
        layout.add("You r in " + model.getProject().getName());
        layout.add("");
        layout.add("Description:" + model.getProject().getShortDescription());
//        TODO: add other fields to layout
        layout.add("");
        layout.add("0) Back");
    }

}
