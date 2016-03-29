package ua.dborisenko.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Project> projects = new ArrayList<Project>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getProjectsCount() {
        return projects.size();
    }
}
