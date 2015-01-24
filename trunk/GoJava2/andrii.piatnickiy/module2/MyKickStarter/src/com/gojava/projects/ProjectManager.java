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

    public void addProject() {
        projectStorage.addToProjectList(null, null, 0, 0, 0);
    }
    
    public void displayProjects() {
        projectStorage.dispalyProjectStorageList();
    }
    
    public void displaySpecificProjectCategory(int i) {
        categoryStorage.displayChoosedCategory(i);
    }


}
