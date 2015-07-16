package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.mvc.model.ProjectPageModel;
import com.tyomsky.kickstarter.ui.Output;

import java.util.ArrayList;

public class ProjectPageView extends AbstractPageView<ProjectPageModel> implements ModelUpdateListener<ProjectPageModel>{

    public ProjectPageView(Output output) {
        super(output);
    }

    @Override
    public void render(ProjectPageModel model) {
        output.print("You are in: " +model.getProject().getName());
        output.print("");
        output.print("description: "+model.getProject().getShortDescription());
        output.print("money needed: "+ model.getProject().getAmountNeeded());
        output.print("money collected: "+ model.getProject().getAmountCollected());
    }

    @Override
    public void onModelUpdate(ProjectPageModel model) {
        render(model);
    }
}
