package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.mvc.model.CategoryPageModel;

import java.util.List;

public class CategoryPageView extends AbstractPageView<CategoryPageModel> implements ModelUpdateListener<CategoryPageModel> {

    public CategoryPageView(Output output) {
        super(output);
    }

    @Override
    public void render(CategoryPageModel model) {
        output.print("You are in: " +model.getName());
        output.print("");
        List<Project> projects = model.getProjects();
        for (int i = 0; i < projects.size(); i++) {
            output.print(String.valueOf(i+1)+") "+projects.get(i).getName());
            output.print("  " + projects.get(i).getShortDescription());
        }
        output.print("");
        output.print("0) Back");
    }

    @Override
    public void onModelUpdate(CategoryPageModel model) {
        render(model);
    }
}
