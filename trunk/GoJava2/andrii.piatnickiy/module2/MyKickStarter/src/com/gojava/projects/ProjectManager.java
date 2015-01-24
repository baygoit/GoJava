package com.gojava.projects;

public class ProjectManager {
    CategoryStorage categoryStorage;
    ProjectStorage projectStorage;

    public ProjectManager(CategoryStorage categoryStorage,
            ProjectStorage projectStorage) {
        this.categoryStorage = categoryStorage;
        this.projectStorage = projectStorage;
    }

    public void addCategory(String name, int categoryId) {
        categoryStorage.addToCategoryStorageList(name, categoryId);
    }

    public void displayCategories() {
        categoryStorage.dispalyCategoryStorageList();
    }

    public void addProject(String name, String description, int needSum, int currentSum, int daysLeft, int categoryId) {
        projectStorage.addToProjectList(name, description, needSum, currentSum, daysLeft, categoryId);
    }
    
    public void displayProjects(int categoryNumber) {
        projectStorage.dispalyProjectStorageList(categoryNumber);
    }
    
    public void displaySpecificProjectCategory(int i) {
        categoryStorage.displayChoosedCategory(i);
    }


}
