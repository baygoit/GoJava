package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {

    DataProvider dataProvider;
    String name;
    List<String> projects = new ArrayList<>();

    public CategoryModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;

    }

    public void update(int index) {

        Category category = dataProvider.getCategory(index);
        name = category.getName();
        List<Project> projects = category.getProjects();
        this.projects.clear();
        for (Project p : projects) {
            this.projects.add(p.getName());
        }

    }

    public String getName() {
        return name;
    }

    public List<String> getProjects() {
        return projects;
    }
}
