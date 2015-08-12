package ua.com.goit.kyrychok.model;

import java.util.List;

public class CategoryModel {
    public String name;
    public List<ProjectModel> projects;

    public String getName() {
        return name;
    }

    public List<ProjectModel> getProjects() {
        return projects;
    }
}
