package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.domain.Project;

import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016
 */

class ProjectTableView {

    private final String[] columnNames;
    private final Object[][] data;

    public ProjectTableView(List<Project> projects) {
        columnNames = generateColumnNames();
        data = generateData(projects);
    }

    private String[] generateColumnNames() {
        String[] result = {"Id", "Name", "Short Desription",
                "Required Budget", "Gathered Budget", "Days left"};
        return result;
    }

    private Object[][] generateData(List<Project> projects) {
        Object[][] result = new Object[projects.size()][columnNames.length];
        for (int projectIndex = 0; projectIndex < projects.size(); projectIndex++) {
            List<Object> row = projects.get(projectIndex).getProjectAsObjectArray();
            int columnIndex = 0;
            for (Object rowElement : row) {
                result[projectIndex][columnIndex++] = rowElement;
            }
        }
        return result;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public Object[][] getData() {
        return data;
    }
}
