package com.morkva.ui;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.model.Repository;

import java.util.List;

/**
 * Created by vladyslav on 22.05.15.
 */
public class Model {
    Repository<Category> categoryRepository;
    private Category currentCategory;
    private Project currentProject;

    public Model(Repository<Category> categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public List<Category> getCategories() {
        return categoryRepository.getAll();
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public Category getCategoryById(int categoryId) {
        return categoryRepository.getById(categoryId);
    }

    public Project getProjectByIdFromCurrentCategory(int id) {
        List<Project> projects = currentCategory.getProjects();
        Project result = null;
        for (Project project : projects) {
            if (project.getId() == id) {
                result = project;
                break;
            }
        }
        return result;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public Project getCurrentProject() {
        return currentProject;
    }
}
