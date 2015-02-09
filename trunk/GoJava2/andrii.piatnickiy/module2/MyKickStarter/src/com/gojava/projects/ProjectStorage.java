package com.gojava.projects;

import java.util.ArrayList;

import com.gojava.inputOutput.Out;

public class ProjectStorage {
    Out out;
    ArrayList<Project> projectStorageList = new ArrayList<Project>();

    public void add(String name, String description, int needSum,
            int currentSum, int daysLeft, String projectHistory,
            String linkOnvideo, String questionsAndAnswers, int categoryId) {
        projectStorageList.add(new Project(name, description, needSum,
                currentSum, daysLeft, projectHistory, linkOnvideo,
                questionsAndAnswers, categoryId));
    }

    public String getAll(int categoryNumber) {
        StringBuffer buffer = new StringBuffer();
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                buffer.append(i).append(") ");
                buffer.append(projectPreviewToString(project)).append("\n");
                i++;
            }
        }
        return buffer.toString();
    }


    public String projectPreviewToString(Project project) {
        StringBuffer sb = new StringBuffer();
        sb.append("Project Name: ").append(project.getName()).append("\n");
        sb.append("Description: ").append(project.getDescription())
                .append("\n");
        sb.append("Need Sum: ").append(project.getNeedSum()).append("\n");
        sb.append("Current Sum: ").append(project.getCurrentSum()).append("\n");
        sb.append("Days Left: ").append(project.getDaysLeft()).append("\n");
        return sb.toString();
    }

    private void previewProject(Project project, Out out) {
        out.print(projectPreviewToString(project));
    }

    public void getSpecificProject(int categoryNumber, int projectNumber) {
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                if (i == projectNumber) {
                    allProjectFields(project);
                }
                i++;
            }
        }
    }

    private void allProjectFields(Project project) {
        out.print(out.printProjectPreview(project));
        out.print(out.printAdditionalProjectFields(project));
    }

    public void setOut(Out out) {
        this.out = out;
    }

    public Project getProject(int index) {
        return projectStorageList.get(index);
    }
    
    // TODO refactoring like code below
    // public Project getSpecificProject(int categoryNumber, int projectNumber)
    // {
    // int i = 1;
    // for (Project project : projectStorageList) {
    // if (project.getCategoryId() == categoryNumber) {
    // if (i == projectNumber) {
    // return project;
    // }
    // i++;
    // }
    // }
    // return null;
    // }
}
