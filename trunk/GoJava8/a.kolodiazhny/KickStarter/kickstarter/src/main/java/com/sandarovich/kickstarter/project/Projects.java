package com.sandarovich.kickstarter.project;

import com.sandarovich.kickstarter.category.Category;
import com.sandarovich.kickstarter.io.Tableable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Olexander Kolodiazhny 2016
 */

public class Projects implements Tableable {
    private final List<Project> projects;

    public Projects() {
        projects = new ArrayList<Project>();
    }

    private Projects(List<Project> projects) {
        this.projects = projects;
    }

    public void add(Project project) {
        projects.add(project);
    }

    public Projects getByCategory(Category category) {
        List<Project> result = new ArrayList<Project>();

        for (Project project : projects)
            if (project.getCategory() == category) {
                result.add(project);
            }
        return new Projects(result);
    }

    @Override
    public int count() {
        return this.projects.size();
    }

    public Project get(int index) {
        return projects.get(index);
    }

    @Override
    public Map<String, Object> getRowData(int index) {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        String[] columns = getColumns();
        Project project = get(index);
        data.put(columns[0], project.getId());
        data.put(columns[1], project.getName());
        data.put(columns[2], project.getShortDescription());
        data.put(columns[3], project.getGoalAmount());
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
