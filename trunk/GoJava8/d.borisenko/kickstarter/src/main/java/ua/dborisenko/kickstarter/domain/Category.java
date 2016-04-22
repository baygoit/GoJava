package ua.dborisenko.kickstarter.domain;

import java.util.Set;

public class Category {

    private int id;
    private String name;
    private Set<Project> projects;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public int getProjectsCount() {
        return projects.size();
    }
}
