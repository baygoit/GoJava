package com.gojava.projects;

import java.util.ArrayList;

public class ProjectCategory {
    String name;
    private ArrayList<Project> projectList = new ArrayList<Project>();

    ProjectCategory(String name, int number) {
        this.name = name;
        projectList.add(new Project("Robot", "I'm robot", 1000, 10, "60"));
        projectList.add(new Project("Car", "I'm car", 2000, 20, "80"));
    }

    public String getName() {
        return name;
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
