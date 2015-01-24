package com.gojava.projects;

import java.util.ArrayList;

public class ProjectManager {
    CategoryStorage categoryStorage;
    ProjectStorage projectStorage;

    public ProjectManager(CategoryStorage categoryStorage, ProjectStorage projectStorage) {
        this.categoryStorage = categoryStorage;
        this.projectStorage = projectStorage;
    }

    public void addCategory(String name, int categoryId) {
        categoryStorage.addToCategoryStorageList(name, categoryId);
    }
    
    public void displayCategories(){
        categoryStorage.dispalyCategoryStorageList();
    }

}
