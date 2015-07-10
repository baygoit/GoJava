package ua.goit.kyrychok.models;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.domain.Category;
import ua.goit.kyrychok.domain.Project;

import java.util.List;

public class CategoryModel {
    private Category category;
    private DataProvider dataProvider;

    public CategoryModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getName() {
        return category.getName();
    }

    public List<Project> getProjects() {
        return category.getProjects();
    }

    public void load(int index) {
        category = dataProvider.getCategory(index);
    }
}
