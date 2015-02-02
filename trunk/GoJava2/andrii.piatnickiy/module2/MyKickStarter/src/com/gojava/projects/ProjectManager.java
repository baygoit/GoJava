package com.gojava.projects;

import com.gojava.input.Out;

public class ProjectManager {
    CategoryStorage categoryStorage;
    ProjectStorage projectStorage;
    Out out;

    public ProjectManager() {
        categoryStorage = new CategoryStorage();
        projectStorage = new ProjectStorage();
        out = new Out();
        projectStorage.setOut(out);
        initCategories();
        initProjects();
    }

    private void initCategories() {
        categoryStorage.add("Sport", 1);
        categoryStorage.add("Car", 2);
        categoryStorage.add("Devices", 3);
    }

    private void initProjects() {
        projectStorage.add("Bicycle", "Bicycle description", 10000, 100, 10,
                "History", "Link on video", "Questions and answers", 1);
        projectStorage.add("Snowboard", "Snowboard description", 2000, 200, 20,
                "History", "Link on video", "Questions and answers", 1);
        projectStorage.add("BMW X3", "BMW X3 description", 30000, 3000, 300,
                "History", "Link on video", "Questions and answers", 2);
        projectStorage.add("Audi Q5", "Audi Q5 description", 40000, 400, 40,
                "History", "Link on video", "Questions and answers", 2);
        projectStorage.add("Laptop", "Laptop description", 500, 50, 50,
                "History", "Link on video", "Questions and answers", 3);
        projectStorage.add("Mobile phone", "Mobile phone description", 60, 60,
                6, "History", "Link on video", "Questions and answers", 3);
    }

    public void displayCategories() {
        categoryStorage.display();
    }

    public void displayProjects(int categoryNumber) {
        projectStorage.getAll(categoryNumber);
    }

    public void displaySpecificProject(int categoryNumber, int projectNumber) {
        projectStorage.getSpecificProject(categoryNumber, projectNumber);
    }

}
