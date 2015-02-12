package com.gojava.projects;

import java.util.ArrayList;

public class ProjectStorage {
    ArrayList<Project> projectStorageList = new ArrayList<Project>();

    public void add(String name, String description, int needSum,
            int currentSum, int daysLeft, String projectHistory,
            String linkOnvideo, String questionsAndAnswers, int categoryId) {
        projectStorageList.add(new Project(name, description, needSum,
                currentSum, daysLeft, projectHistory, linkOnvideo,
                questionsAndAnswers, categoryId));
    }

    public String getAll(int categoryNumber) {
        StringBuffer sb = new StringBuffer();
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                sb.append(i).append(") ");
                sb.append(getprojectPreviewToString(project)).append("\n");
                i++;
            }
        }
        return sb.toString();
    }

    public String getSpecificProjectToString(int categoryNumber,
            int projectNumber) {
        StringBuffer sb = new StringBuffer();
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                if (i == projectNumber) {
                    sb.append(allProjectFields(project)).append("\n");
                }
                i++;
            }
        }
        return sb.toString();
    }

    private String allProjectFields(Project project) {
        return getprojectPreviewToString(project)
                + getAdditionalProjectFields(project);
    }

    public String getprojectPreviewToString(Project project) {
        StringBuffer sb = new StringBuffer();
        sb.append("Project Name: ").append(project.getName()).append("\n");
        sb.append("Description: ").append(project.getDescription())
                .append("\n");
        sb.append("Need Sum: ").append(project.getNeedSum()).append("\n");
        sb.append("Current Sum: ").append(project.getCurrentSum()).append("\n");
        sb.append("Days Left: ").append(project.getDaysLeft()).append("\n");
        return sb.toString();
    }

    public String getAdditionalProjectFields(Project project) {
        StringBuffer sb = new StringBuffer();
        sb.append("ProjectHistory: ").append(project.getProjectHistory())
                .append("\n");
        sb.append("LinkOnvideo: ").append(project.getLinkOnvideo())
                .append("\n");
        sb.append("Questions and answers: ")
                .append(project.getQuestionsAndAnswers()).append("\n");
        return sb.toString();
    }

    public Project getProject(int index) {
        return projectStorageList.get(index);
    }

    public Project getSpecificProject(int categoryNumber, int projectNumber) {
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                if (i == projectNumber) {
                    return project;
                }
                i++;
            }
        }
        return null;
    }
}
