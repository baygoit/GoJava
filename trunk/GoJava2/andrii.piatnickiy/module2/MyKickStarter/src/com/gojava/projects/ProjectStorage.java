package com.gojava.projects;

import java.util.ArrayList;

import com.gojava.input.Out;

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

    public void displayAll(int categoryNumber) {
        int i = 1;
        for (Project project : this.projectStorageList) {
            if (project.getCategoryId() == categoryNumber) {
                out.output(i, ") ");
                previewProject(project, out);
                out.output("");
                ;
                i++;
            }
        }
    }

//    public void displaySpecific(int categoryNumber, int projectNumber) {
//        int i = 1;
//        for (Project project : projectStorageList) {
//            if (project.getCategoryId() == categoryNumber) {
//                if (i == projectNumber) {
//                    displayAllProjectFields(project);
//                    System.out.println();
//                }
//                i++;
//            }
//        }
//    }
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

    private void previewProject(Project project, Out out) {

        out.printProjectPreview(project);
        // out.print(out.output("Project Name: ", project.getName()));
        // out.print(out.output("Description: ", project.getDescription()));
        // out.print(out.output("Need Sum: ", project.getNeedSum()));
        // out.print(out.output("Current Sum: ", project.getCurrentSum()));
        // out.print(out.output("Days Left: ", project.getDaysLeft()));
        // System.out.println("Project Name: " + project.getName());
        // System.out.println("Description: " + project.getDescription());
        // System.out.println("Need Sum: " + project.getNeedSum());
        // System.out.println("Current Sum: " + project.getCurrentSum());
        // System.out.println("Days Left: " + project.getDaysLeft());
    }

    private void displayAllProjectFields(Project project) {
        previewProject(project, out);
        System.out.println("ProjectHistory: " + project.getProjectHistory());
        System.out.println("LinkOnvideo: " + project.getLinkOnvideo());
        System.out.println("Questions and answers: "
                + project.getQuestionsAndAnswers());
    }

    public void setOut(Out out) {
        this.out = out;
    }
}
