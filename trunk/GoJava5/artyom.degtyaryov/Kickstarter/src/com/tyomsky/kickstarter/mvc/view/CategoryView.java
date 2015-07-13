package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.mvc.model.AbstractModel;
import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.mvc.model.CategoryModel;

import java.util.List;

public class CategoryView extends AbstractView {

    public CategoryView(Output output) {
        super(output);
    }

    @Override
    protected void prepareLayout(AbstractModel model) {
        CategoryModel categoryModel = ((CategoryModel) model);
        layout.clear();
        layout.add("You r in " + categoryModel.getName());
        layout.add("");
        layout.add("Choose project:");
        fillMenu(categoryModel);
    }

    private void fillMenu(CategoryModel model){
        List<String> projects = model.getProjects();
        for (int i = 1; i < projects.size(); i++) {
            layout.add(i+") "+projects.get(i-1));
        }
        layout.add("");
        layout.add("0) Back");


    }
}
