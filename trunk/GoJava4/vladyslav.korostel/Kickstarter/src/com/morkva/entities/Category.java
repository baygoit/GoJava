package com.morkva.entities;

/**
 * Created by vladyslav on 02.05.15.
 */
public class Category {

    private String name;
    private Project[] projects;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }
}
