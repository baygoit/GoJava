package com.sandarovich.kickstarter.dao.category;

import com.sandarovich.kickstarter.domain.Award;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;

import java.util.List;

/**
 * Category DAO
 */

public interface CategoryDao {
    List<Category> getCategories();
    Category findCategoryById(int id);
    boolean isValidCategory(String category);
    Project findProject(Category category, String inputValue);
    List<Project> getProjects(Category category);

    void addQuestion(Project project, String question);

    void investIntoProject(Project project, double amount);

    List<Award> getProjectAwards(Project project);
}
