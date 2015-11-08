package ua.com.goit.kyrychok.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Project> projects = new ArrayList<>();
    private int id;

    public Category(String name) {
        this.name = name;
        projects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

}
