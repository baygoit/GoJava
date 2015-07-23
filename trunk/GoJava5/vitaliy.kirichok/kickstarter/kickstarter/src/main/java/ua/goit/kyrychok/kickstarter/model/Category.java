package ua.goit.kyrychok.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Project> projects;
    private int id;

    public Category(String name) {
        this.name = name;
        projects = new ArrayList<>();
    }

    public int getId() {
        return id;
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
