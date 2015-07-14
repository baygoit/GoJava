package com.tyomsky.kickstarter.model;

import java.util.List;

public class Category {

    private String name;

    private List<Project> projects;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
