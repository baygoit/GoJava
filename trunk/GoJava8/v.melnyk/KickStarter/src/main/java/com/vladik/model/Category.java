package com.vladik.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private int id;
    private String name;
    private List<Project> projects = new ArrayList<Project>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void addProject(Project project) {
        projects.add(project);
    }

    public int getProjectsCount() {
        return projects.size();
    }
    @Override
    public String toString() {
        return "id : " + id + ", name : " + name;
    }
}
