package com.gojava.projects;

public class ProjectManager {
    CategoryStorage categoryStorage;
    ProjectStorage projectStorage;
    
    public ProjectManager() {
        this.categoryStorage = new CategoryStorage();
       this.projectStorage = new ProjectStorage();
       initCategories();
       initProjects();
    }

    
    private void initCategories()
    {
        categoryStorage.addToCategoryStorageList("Sport", 1);
        categoryStorage.addToCategoryStorageList("Car", 2);
        categoryStorage.addToCategoryStorageList("Devices", 3);
    }
    
    private void initProjects(){
        projectStorage.addToProjectList("Bicycle", "Bicycle description", 10000, 100, 10, "History", "Link on video", "Questions and answers", 1);
        projectStorage.addToProjectList("Snowboard", "Snowboard description", 2000, 200, 20, "History", "Link on video", "Questions and answers", 1);
        projectStorage.addToProjectList("BMW X3", "BMW X3 description", 30000, 3000, 300, "History", "Link on video", "Questions and answers", 2);
        projectStorage.addToProjectList("Audi Q5", "Audi Q5 description", 40000, 400, 40, "History", "Link on video", "Questions and answers", 2);
        projectStorage.addToProjectList("Laptop", "Laptop description", 500, 50, 50, "History", "Link on video", "Questions and answers", 3);
        projectStorage.addToProjectList("Mobile phone", "Mobile phone description", 60, 60, 6, "History", "Link on video", "Questions and answers", 3);
    }
    

    public void displayCategories() {
        categoryStorage.dispalyCategoryStorageList();
    }


    public void displayProjects(int categoryNumber) {
        projectStorage.dispalyProjectStorageList(categoryNumber);
    }

    public void displaySpecificProjectCategory(int i) {
        categoryStorage.displayChoosedCategory(i);
    }

    public void displaySpecificProject(int categoryNumber,int projectNumber) {
        projectStorage.displaySpecificProject(categoryNumber, projectNumber);
    }

}
