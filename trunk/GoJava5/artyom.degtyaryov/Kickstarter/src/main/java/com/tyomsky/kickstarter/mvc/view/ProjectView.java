package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.ui.Output;

import java.util.ArrayList;

public class ProjectView {

    private ArrayList<String> layout = new ArrayList<>();
    private Output output;

    public ProjectView(Output output) {
        this.output = output;
    }

    protected void prepareLayout(ProjectModel model) {
        ProjectModel projectModel = model;
        layout.clear();
        layout.add("You r in " + projectModel.getProject().getName());
        layout.add("");
        layout.add("Description:" + projectModel.getProject().getShortDescription());
//        TODO: add other fields to layout
        layout.add("");
        layout.add("0) Back");
    }

    public void show(ProjectModel model) {
        prepareLayout(model);
        output.print(layout);
    }

}
