package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.List;

public class CategoryModel {
    private DataProvider dataProvider;
    private Category category;

    public CategoryModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getName() {
        return category.getName();
    }

    public List<Project> getProjects() {
        return category.getProjects();
    }

    public void update(int index) {
        category = dataProvider.getCategory(index);
    }
}
