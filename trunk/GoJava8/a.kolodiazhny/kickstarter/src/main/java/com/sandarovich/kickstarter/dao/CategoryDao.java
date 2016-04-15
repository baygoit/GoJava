package com.sandarovich.kickstarter.dao;

import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;

import java.util.List;

public interface CategoryDao {
    List<Category> getCategories();

    Category findById(int id);

    Category findByProject(Project project);
}
