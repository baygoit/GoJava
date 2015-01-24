package com.gojava.projects;

import java.util.ArrayList;

public class ProjectStorage {
    ArrayList<Project> projectStorageList = new ArrayList<Project>();

    public void addToProjectList(String name, String description, int needSum,
            int currentSum, int daysLeft, int categoryId) {
        projectStorageList.add(new Project(name, description, needSum,
                currentSum, daysLeft, categoryId));
    }

    public void dispalyProjectStorageList(int categoryNumber) {
        for (Project project : this.projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                System.out.println("Project Name: " + project.getName());
                System.out.println("Description: " + project.getDesc());
                System.out.println("Need Sum: " + project.getNeedSum());
                System.out.println("Current Sum: " + project.getCurrentSum());
                System.out.println("Days Left: " + project.getDaysLeft());
                System.out.println();
            }
        }
    }
}
