package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.mvc.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryView {

    private ArrayList<String> layout = new ArrayList<>();
    private Output output;

    public CategoryView(Output output) {
        this.output = output;
    }

    private void prepareLayout(CategoryModel model) {
        layout.clear();
        layout.add("You r in " + model.getName());
        layout.add("");
        layout.add("Choose project:");
        fillMenu(model);
    }

    private void fillMenu(CategoryModel model) {
        List<String> projects = model.getProjects();
        for (int i = 0; i < projects.size(); i++) {
            layout.add(String.valueOf(i + 1) + ") " + projects.get(i));
        }
        layout.add("");
        layout.add("0) Back");
    }

    public void show(CategoryModel model) {
        prepareLayout(model);
        output.print(layout);
    }

}
