package com.sandarovich.kickstarter.project;

import com.sandarovich.kickstarter.category.Category;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * P
 */

public class ProjectSource implements ProjectSerializable {
    private final List<Project> projects;

    public ProjectSource() {
        projects = new ArrayList<Project>();
    }

    private ProjectSource(List<Project> projects) {
        this.projects = projects;
    }

    public void add(Project project) {
        projects.add(project);
    }

    public ProjectSource getByCategory(Category category) {
        ArrayList<Project> result = new ArrayList<Project>();

        for (Project project : projects)
            if (project.getCategory() == category) {
                result.add(project);
            }
        return new ProjectSource(result);
    }

    @Override
    public int count() {
        return this.projects.size();
    }

    public Project get(int index) {
        return projects.get(index);
    }

    public Project search(int index) {
        for (Project project : projects) {
            if (project.getId() == index) {
                return project;
            }
        }
        return null;
    }


    @Override
    public Map<String, Object> getRowData(int index) {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        String[] columns = getColumns();
        Project project = get(index);
        data.put(columns[0], project.getId());
        data.put(columns[1], project.getName());
        data.put(columns[2], project.getShortDescription());
        data.put(columns[3], project.getRequiredBudget());
        data.put(columns[4], project.getCollectedAmount());
        data.put(columns[5], project.getGoalDateDays());
        return data;
    }

    @Override
    public String[] getColumns() {
        String[] result = {"Id", "Name", "Description", "Goal Amount", "Collected Amount", "Days left"};
        return result;
    }

}
