package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
    private int id;

    private final String name;

    private final List<Project> projects;

    public Category(String name) {
        this.name = name;
        projects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void add(Project project) {
        projects.add(project);
    }

}
