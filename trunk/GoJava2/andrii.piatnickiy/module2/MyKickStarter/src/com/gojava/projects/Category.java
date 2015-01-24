package com.gojava.projects;

import java.util.ArrayList;

public class Category {
    private String name;
    private int categoryId;

    private ArrayList<Project> projectList = new ArrayList<Project>();

    Category(String name, int categoryId) {
        this.name = name;
        this.categoryId = categoryId; 
        projectList.add(new Project("Robot", "I'm robot", 1000, 10, "60", 1));
        projectList.add(new Project("Car", "I'm car", 2000, 20, "80", 1));
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void dispalyProjectList() {
        for (Project project : this.projectList) {
            System.out.println("Name: " + project.getName());
            System.out.println("Description: " + project.getDesc());
            System.out.println("Need Sum: " + project.getNeedSum());
            System.out.println("Current Sum: " + project.getCurrentSum());
            System.out.println("Days Left: " + project.getDaysLeft());
            System.out.println();
        }
    }
}
