package ua.dborisenko.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Project> projects = new ArrayList<Project>();

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public Project getProjectByListNumber(int number) {
        return projects.get(number);
    }
    
    public int getProjectsCount() {
        return projects.size();
    }
}
