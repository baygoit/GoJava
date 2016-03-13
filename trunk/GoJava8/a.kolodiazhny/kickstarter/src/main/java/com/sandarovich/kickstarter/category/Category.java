package com.sandarovich.kickstarter.category;

import com.sandarovich.kickstarter.project.Project;

import java.util.List;

/**
 * @author Olexander Kolodiazhny
 */

public class Category {

    private final int id;
    private final String name;
    private List<Project> projects;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return id + " -> " + name;
    }
}
