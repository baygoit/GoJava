package com.gojava.projects;

public interface ProjectStorage {

    public abstract void add(String name, String description, int needSum,
            int currentSum, int daysLeft, String projectHistory,
            String linkOnvideo, String questionsAndAnswers, int categoryId);

    public abstract String getAllToString(int categoryNumber);

    public abstract String getSpecificProjectToString(int categoryNumber,
            int projectNumber);

    public abstract String getprojectPreviewToString(Project project);

    public abstract String getAdditionalProjectFields(Project project);

    public abstract Project getProject(int index);

    public abstract Project getSpecificProject(int categoryNumber,
            int projectNumber);

}