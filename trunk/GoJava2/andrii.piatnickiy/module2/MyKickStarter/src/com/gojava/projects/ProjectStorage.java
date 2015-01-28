package com.gojava.projects;

import java.util.ArrayList;

public class ProjectStorage {
    public static int projectsCount = 0;
    ArrayList<Project> projectStorageList = new ArrayList<Project>();

    public void addToProjectList(String name, String description, int needSum,
            int currentSum, int daysLeft, String projectHistory,
            String linkOnvideo, String questionsAndAnswers, int categoryId) {
        projectStorageList.add(new Project(name, description, needSum,
                currentSum, daysLeft, projectHistory, linkOnvideo,
                questionsAndAnswers, categoryId));
    }

    public void dispalyProjectStorageList(int categoryNumber) {
        // TODO refactoring sysout to toString();
        int i = 1;
        for (Project project : this.projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                System.out.println(i + ") Project Name: " + project.getName());
                System.out.println("Description: " + project.getDescription());
                System.out.println("Need Sum: " + project.getNeedSum());
                System.out.println("Current Sum: " + project.getCurrentSum());
                System.out.println("Days Left: " + project.getDaysLeft());
                System.out.println();
                i++;
            }
        }
        System.out.println("111");
    }

    public void displaySpecificProject(int categoryNumber, int projectNumber) {
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                if (i == projectNumber) {
                    System.out.println("Project Name: " + project.getName());
                    System.out.println("Description: "
                            + project.getDescription());
                    System.out.println("Need Sum: " + project.getNeedSum());
                    System.out.println("Current Sum: "
                            + project.getCurrentSum());
                    System.out.println("Days Left: " + project.getDaysLeft());
                    System.out.println("ProjectHistory: "
                            + project.getProjectHistory());
                    System.out.println("LinkOnvideo: "
                            + project.getLinkOnvideo());
                    System.out.println("Questions and answers: "
                            + project.getQuestionsAndAnswers());
                    System.out.println();
                }
                i++;
            }
        }
    }
}
