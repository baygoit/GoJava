package com.gojava.projects;

import java.util.ArrayList;

public class ProjectStorage {
    public static int projectsCount = 0;
    ArrayList<Project> projectStorageList = new ArrayList<Project>();

    public void add(String name, String description, int needSum,
            int currentSum, int daysLeft, String projectHistory,
            String linkOnvideo, String questionsAndAnswers, int categoryId) {
        projectStorageList.add(new Project(name, description, needSum,
                currentSum, daysLeft, projectHistory, linkOnvideo,
                questionsAndAnswers, categoryId));
    }

    public void displayAll(int categoryNumber) {
        int i = 1;
        for (Project project : this.projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                System.out.print(i + ") ");
                previewProject(project);
                System.out.println();
                i++;
            }
        }
    }

    public void displaySpecific(int categoryNumber, int projectNumber) {
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                if (i == projectNumber) {
                    displayAllProjectFields(project);
                }
                i++;
            }
        }
    }

    private void previewProject(Project project) {
        System.out.println("Project Name: " + project.getName());
        System.out.println("Description: " + project.getDescription());
        System.out.println("Need Sum: " + project.getNeedSum());
        System.out.println("Current Sum: " + project.getCurrentSum());
        System.out.println("Days Left: " + project.getDaysLeft());
    }

    private void displayAllProjectFields(Project project) {
        previewProject(project);
        System.out.println("ProjectHistory: " + project.getProjectHistory());
        System.out.println("LinkOnvideo: " + project.getLinkOnvideo());
        System.out.println("Questions and answers: "
                + project.getQuestionsAndAnswers());
        System.out.println();
    }
}
