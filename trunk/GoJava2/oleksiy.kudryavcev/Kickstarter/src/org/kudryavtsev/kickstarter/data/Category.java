package org.kudryavtsev.kickstarter.data;

import java.util.ArrayList;
import java.util.List;

public class Category {
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((projectsList == null) ? 0 : projectsList.hashCode());
        return result;
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
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (projectsList == null) {
            if (other.projectsList != null) {
                return false;
            }
        } else if (!projectsList.equals(other.projectsList)) {
            return false;
        }
        return true;
    }

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
