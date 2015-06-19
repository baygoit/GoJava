package com.morkva.ui;

import com.morkva.entities.Category;
import com.morkva.entities.PaymentOption;
import com.morkva.entities.Project;
import com.morkva.model.CategoryRepository;
import com.morkva.model.PaymentOptionRepository;
import com.morkva.model.ProjectRepository;
import com.morkva.utils.UserType;

import java.util.List;

/**
 * Created by vladyslav on 22.05.15.
 */
public class Model {
    CategoryRepository categoryRepository;
    ProjectRepository projectRepository;
    PaymentOptionRepository paymentOptionRepository;

    private Category currentCategory;
    private Project currentProject;
    private UserType currentUserType;

    public Model(CategoryRepository categoryRepository, ProjectRepository projectRepository, PaymentOptionRepository paymentOptionRepository) {
        this.categoryRepository = categoryRepository;
        this.projectRepository = projectRepository;
        this.paymentOptionRepository = paymentOptionRepository;
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

    public List<Project> getProjectsFromCategory(Category category) {
        return projectRepository.getProjectsForCategory(category);
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentUserType(UserType currentUserType) {
        this.currentUserType = currentUserType;
    }

    public UserType getCurrentUserType() {
        return currentUserType;
    }

    public Project getProjectById(Integer keyCode) {
        return projectRepository.getById(keyCode);
    }

    public List<PaymentOption> getPaymentOptionsForProject(Project project) {
        return paymentOptionRepository.getPaymentOptionsForProject(project);
    }

    public void saveProject(Project project) {
        projectRepository.update(project);
    }
}
