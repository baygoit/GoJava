package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {

    private DataProvider dataProvider;

    private Category category;

    public CategoryModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;

    }

    public void update(int index) {

        category = dataProvider.getCategory(index);

    }

    public String getName() {
        return category.getName();
    }

    public List<Project> getProjects() {
        return category.getProjects();
    }

    public Category getCategory() {
        return category;
    }
}
