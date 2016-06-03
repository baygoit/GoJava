package ua.dborisenko.kickstarter.dto;

import java.util.List;

import ua.dborisenko.kickstarter.domain.Project;

public class CategoryDto {

    private int id;
    private String name;
    private List<Project> projects;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
