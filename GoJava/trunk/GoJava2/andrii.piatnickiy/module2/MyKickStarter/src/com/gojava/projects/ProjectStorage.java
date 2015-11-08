package com.gojava.projects;

import java.util.ArrayList;

public interface ProjectStorage {

    void add(String name, String description, int needSum, int currentSum,
            int daysLeft, String projectHistory, String linkOnvideo,
            String questionsAndAnswers, int categoryId);

    String getAllToString(int categoryNumber);

    String getSpecificProjectToString(int categoryNumber, int projectNumber);

    String getprojectPreviewToString(Project project);

    String getAdditionalProjectFields(Project project);

    Project getProject(int index);

    Project getSpecificProject(int categoryNumber, int projectNumber);

    ArrayList<Project> getList();

}