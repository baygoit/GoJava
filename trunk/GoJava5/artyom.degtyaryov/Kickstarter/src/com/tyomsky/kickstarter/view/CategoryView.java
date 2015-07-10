package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.model.CategoryModel;

import java.util.List;

public class CategoryView extends AbstractView {

    private CategoryModel model;

    public CategoryView(CategoryModel model, Output output) {
        super(output);
        this.model = model;
    }

    @Override
    protected void prepareLayout() {
        layout.clear();
        layout.add("You r in " + model.getName());
        layout.add("");
        layout.add("Choose project:");
        fillMenu();
    }

    private void fillMenu(){
        List<String> projects = model.getProjects();
        for (int i = 1; i < projects.size(); i++) {
            layout.add(i+") "+projects.get(i-1));
        }
        layout.add("");
        layout.add("0) Back");


    }
}
