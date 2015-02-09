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

    public void getAll(int categoryNumber) {
        int i = 1;
        for (Project project : projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                out.print(out.output(i, ") "));
                previewProject(project, out);
                System.out.println();
                i++;
            }
        }
    }

    public Project getProject(int index){
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

    private void previewProject(Project project, Out out) {
        out.print(out.printProjectPreview(project));
    }

    private void allProjectFields(Project project) {
        out.print(out.printProjectPreview(project));
        out.print(out.printAdditionalProjectFields(project));
    }

    public void setOut(Out out) {
        this.out = out;
    }
}
