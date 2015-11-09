package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro on 06.11.2015.
 */
public class Category {
    private final String name;

    private final List<Project> projects;

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Category(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }
}
