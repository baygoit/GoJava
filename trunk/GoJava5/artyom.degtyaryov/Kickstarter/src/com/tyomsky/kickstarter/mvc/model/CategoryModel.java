package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel extends AbstractModel{

    String name;

    List<String> projects = new ArrayList<>();

    public CategoryModel(DataProvider dataProvider) {
        super(dataProvider);

    }

    @Override
    public void update(int... parameters) {
        if (parameters.length != 0) {
            Category category = dataProvider.getCategory(parameters[0]);
            name = category.getName();
            List<Project> projects = category.getProjects();
            this.projects.clear();
            for (Project p : projects) {
                this.projects.add(p.getName());
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getProjects() {
        return projects;
    }
}
