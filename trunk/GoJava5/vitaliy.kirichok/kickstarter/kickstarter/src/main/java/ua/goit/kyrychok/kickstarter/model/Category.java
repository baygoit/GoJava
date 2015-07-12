package ua.goit.kyrychok.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Project> projects;

    public Category(String name) {
        this.name = name;
        projects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

}
