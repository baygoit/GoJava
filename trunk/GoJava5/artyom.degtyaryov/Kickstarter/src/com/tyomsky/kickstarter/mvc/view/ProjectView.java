package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.mvc.model.AbstractModel;
import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.ui.Output;

public class ProjectView extends AbstractView  {

    public ProjectView(Output output) {
        super(output);
    }

    @Override
    protected void prepareLayout(AbstractModel model) {
        ProjectModel projectModel = ((ProjectModel) model);
        layout.clear();
        layout.add("You r in " + projectModel.getProject().getName());
        layout.add("");
        layout.add("Description:" + projectModel.getProject().getShortDescription());
//        TODO: add other fields to layout
        layout.add("");
        layout.add("0) Back");
    }

}
