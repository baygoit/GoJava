package com.tyomsky.kickstarter.dao;

import java.util.*;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.view.ViewTypes;
import com.tyomsky.kickstarter.model.Entity;
import com.tyomsky.kickstarter.model.Quote;

public class MockDataProvider implements DataProvider {
    private ArrayList<Category> categories = new ArrayList<>();
    private HashMap<Category, ArrayList<Project>> projects = new HashMap<>();

    public MockDataProvider() {
        Random random = new Random();
        for (int i = 0; i < 5 + random.nextInt(5); i++) {
            Category category = new Category(i, "Category " + i);
            categories.add(category);
            projects.put(category, new ArrayList<Project>());
            for (int j = 0; j < 5 + random.nextInt(9); j++) {
                Project project = new Project(j, "project " + j,
                        "description of project" + j, random.nextInt(3000),
                        random.nextInt(2500), random.nextInt(100),
                        "history of project" + j, "www.youtube.com/?video=" + j + random.nextInt() + "/",
                        null, category);
                projects.get(category).add(project);
            }
        }
    }

    @Override
    public ArrayList<Category> getCategoriesList() {
        return categories;
    }

    @Override
    public Entity getSomeQuote() {
        return new Quote(12, "Explore projects, everywhere\n" +
                "Check out Kickstarter for Anroid, iPhone and iPad - now with Power Shell!!");
    }

    @Override
    public ArrayList<Project> getProjectsList(int categoryIndex) {
        return projects.get(categories.get(categoryIndex - 1));
    }

    @Override
    public String getCategoryName(int categoryIndex) {
        return categories.get(categoryIndex - 1).getName();
    }

    @Override
    public Project getProject(int categoryIndex, int projectIndex) {
        return getProjectsList(categoryIndex).get(projectIndex - 1);
    }

    @Override
    public ArrayList<Entity> getEntitiesList(ViewTypes viewType, int id) {
        ArrayList<Entity> result = new ArrayList<>();
        switch (viewType) {
            case Main:
                result.addAll(categories);
                break;
            case Category:
                result.addAll(getProjectsList(id));
                break;
            case Project:
                break;
            case Exit:
                break;
        }
        return result;
    }


}
