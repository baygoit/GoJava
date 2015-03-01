package org.kudryavtsev.kickstarter.data;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private String description;
    private List<Project> projects;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.projects = new ArrayList<Project>();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Category other = (Category) obj;
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjectsList(List<Project> projects) {
        this.projects = projects;
    }
}
