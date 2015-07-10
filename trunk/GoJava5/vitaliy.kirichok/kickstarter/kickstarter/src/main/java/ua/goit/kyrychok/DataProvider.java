package ua.goit.kyrychok;

import ua.goit.kyrychok.domain.Category;
import ua.goit.kyrychok.domain.Project;

import java.util.ArrayList;
import java.util.List;

import static ua.goit.kyrychok.common.Utils.convertDate;

public class DataProvider {
    private List<Category> data;

    public void init() {
        data = new ArrayList<>();
        Category category;
        Project project;
        category = new Category("Category 1");
        project = new Project("1st project in 1st category", "description", "desc", 1000000, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        project = new Project("2st project in 1st category", "description2", "desc2", 10000, 3500, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        data.add(category);
        category = new Category("Category 2");
        project = new Project("1st project in 2st category", "description21", "desc21", 1000000, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        data.add(category);
        category = new Category("Empty category");
        data.add(category);
    }

    public List<Category> getCategories() {
        return data;
    }

    public Category getCategory(int index) {
        return data.get(index);
    }

    public Project getProject(int categoryIndex, int projectIndex) {
        return data.get(categoryIndex).getProjects().get(projectIndex);
    }
}
