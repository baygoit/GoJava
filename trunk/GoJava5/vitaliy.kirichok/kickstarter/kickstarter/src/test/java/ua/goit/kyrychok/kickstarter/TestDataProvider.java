package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import java.util.ArrayList;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.convertDate;

public class TestDataProvider {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void init() {
        categories = new ArrayList<>();
        Category category;
        Project project;
        category = new Category("Category 1");
        project = new Project("1st project", "desc", 10010, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"), "http://stackoverflow.com/");
        project.addFaq(new Faq("Question 1", "Answer on question 1"));
        project.addFaq(new Faq("Question 2", "Answer on question 2"));
        project.addProjectEvent(new ProjectEvent(convertDate("01.01.2015"), "Project event 1"));
        project.addProjectEvent(new ProjectEvent(convertDate("01.07.2015"), "Project event 2"));
        category.addProject(project);
        project = new Project("2nd project", "desc", 10010, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"), "http://stackoverflow.com/");
        category.addProject(project);
        categories.add(category);
        categories.add(new Category("Category 2"));
        categories.add(new Category("Category 3"));
    }

    public List<Project> getProjects(int categoryIndex) {
        return categories.get(categoryIndex).getProjects();
    }

    public Category getCategory(int categoryIndex) {
        return categories.get(categoryIndex);
    }

    public Project getProject(int categoryIndex, int projectIndex) {
        return categories.get(categoryIndex).getProjects().get(projectIndex);
    }
}
