package com.sandarovich.kickstarter.domain;

import java.util.List;

/**
 * @author Olexander Kolodiazhny
 */

public class Category {

    private final int id;
    private final String name;
    private List<Project> projects;

    public Category(int id, String name, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
