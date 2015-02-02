package org.kudryavtsev.kickstarter.data;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private String description;
    private List<Project> projectsList;

    public Category() {
        this("Other", "For other projects");
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        setProjectsList(new ArrayList<Project>());
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Project> projectsList) {
        this.projectsList = projectsList;
    }
}
