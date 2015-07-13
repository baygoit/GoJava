package com.tyomsky.kickstarter.dao;

import java.util.*;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;

public class MockDataProvider implements DataProvider {
    private List<Category> categories = new ArrayList<>();

    public MockDataProvider() {
        Random random = new Random();
        for (int i = 0; i < 5 + random.nextInt(5); i++) {
            Category category = new Category("Category " + i);
            categories.add(category);
            List<Project> projects = new ArrayList<>();
            for (int j = 0; j < 5 + random.nextInt(9); j++) {
                Project project = new Project("project " + j,
                        "description of project" + j, random.nextInt(3000),
                        random.nextInt(2500), random.nextInt(100),
                        "history of project" + j, "www.youtube.com/?video=" + j + random.nextInt() + "/",
                        null);
                projects.add(project);
            }
            category.setProjects(projects);
        }
    }

    @Override
    public List<Category> getCategoriesList() {
        return categories;
    }

    @Override
    public String getSomeQuote() {
        return "WOW! SSUCH QUOTE!";
    }

    @Override
    public Category getCategory(int categoryIndex) {
        return categories.get(categoryIndex);
    }

    @Override
    public Project getProject(int categoryIndex, int projectIndex) {
        return categories.get(categoryIndex).getProjects().get(projectIndex);
    }

}
