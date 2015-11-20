package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String name;

    private final List<Project> projects;

    public Category(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
