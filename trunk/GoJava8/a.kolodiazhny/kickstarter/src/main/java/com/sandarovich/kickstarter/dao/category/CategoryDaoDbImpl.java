package com.sandarovich.kickstarter.dao.category;


import com.sandarovich.kickstarter.domain.Award;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;
import com.sandarovich.kickstarter.domain.ProjectBuilder;

import java.util.ArrayList;
import java.util.List;

//TODO IMPLEMENT DB.INTERFACE DUE TO 30/03/16
//TODO IMPLEMENT DB.INTERFACE DUE TO 30/03/16
//TODO IMPLEMENT DB.INTERFACE DUE TO 30/03/16

public class CategoryDaoDbImpl implements CategoryDao {

    private final List<Category> categories = new ArrayList<Category>();

    public CategoryDaoDbImpl() {
        fillCategories();
    }

    public void add(Category category) {
        categories.add(category);
    }

    void fillCategories() {
        add(new Category(1, "IT", getITProjects()));
        add(new Category(2, "Tourism", getTourismProjects()));
        add(new Category(3, "Garden", getGardenProjects()));
    }

    private List<Project> getITProjects() {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(1)
                .andName("USB TOY   ")
                .andDescription("Not Ordinary gameplay ")
                .andRequiredBudget(2000d)
                .andAward(new Award(1d, "Free Calendar"))
                .andAward(new Award(5d, "Free Magneto"))
                .andAward(new Award(250d, "Free Business trip"))
                .build();
        builder.forId(102)
                .andName("Power Bank")
                .andDescription("Unique technology ")
                .andRequiredBudget(1200d)
                .andAward(new Award(1d, "Free Calendar"))
                .andAward(new Award(5d, "Free Magneto"))
                .andAward(new Award(250d, "Free Business trip"))
                .build();
        builder.forId(3)
                .andName("Robot Frodo")
                .andDescription("Fast and Smart")
                .andRequiredBudget(7000d)
                .andAward(new Award(1d, "Free Calendar"))
                .andAward(new Award(5d, "Free Magneto"))
                .andAward(new Award(250d, "Free Business trip"))
                .build();
        builder.forId(97);
        return builder.getProjects();
    }

    private List<Project> getTourismProjects() {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(5)
                .andName("Super Bag")
                .andDescription("Auto resizable")
                .andAward(new Award(1d, "Free Calendar"))
                .andAward(new Award(5d, "Free Magneto"))
                .andAward(new Award(250d, "Free Business trip"))
                .build();
        return builder.getProjects();
    }

    private List<Project> getGardenProjects() {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(97)
                .andName("Bison grass")
                .andDescription("Power energy from sun")
                .andAward(new Award(1d, "Free Calendar"))
                .andAward(new Award(5d, "Free Magneto"))
                .andAward(new Award(250d, "Free Business trip"))
                .build();
        builder.forId(77)
                .andName("Garfield grass")
                .andDescription("Feel exotic")
                .andAward(new Award(1d, "Free Calendar"))
                .andAward(new Award(5d, "Free Magneto"))
                .andAward(new Award(250d, "Free Business trip"))
                .build();
        return builder.getProjects();
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    @Override
    public boolean isValidCategory(String category) {
        int categoryId;
        try {
            categoryId = Integer.parseInt(category);
        } catch (Exception e) {
            return false;
        }
        return findCategoryById(categoryId) != null;
    }

    @Override
    public Project findProject(Category category, String inputValue) {
        Project result = null;
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            return null;
        }

        for (Project project : category.getProjects()) {
            if (project.getId() == Integer.parseInt(inputValue)) {
                return project;
            }
        }
        return result;
    }

    @Override
    public List<Project> getProjects(Category category) {
        return category.getProjects();
    }

    @Override
    public void addQuestion(Project project, String question) {
        project.addQuestion(question);
    }

    @Override
    public void investIntoProject(Project project, double amount) {
        project.invest(amount);
    }

    @Override
    public List<Award> getProjectAwards(Project project) {
        return project.getAwards();
    }
}
