package com.sandarovich.kickstarter.dao.category;

import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;
import com.sandarovich.kickstarter.domain.Question;

import java.util.List;

/**
 * Category DAO
 */

public interface CategoryDao {
    List<Category> getCategories();
    Category findCategoryById(int id);
    List<Project> getProjects(Category category);
    Project findProjectById(int projectId);
    List<Question> getQuestions(Project project);
    void addQuestion(Question question, int projectId);

    Category findCategoryByProject(Project project);
}
