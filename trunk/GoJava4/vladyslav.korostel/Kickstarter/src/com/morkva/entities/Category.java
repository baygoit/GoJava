package com.morkva.entities;

import java.util.Arrays;

/**
 * Created by vladyslav on 02.05.15.
 */
public class Category extends Entity{

    private String name;
    private Project[] projects;

    public Category(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", projects=" + Arrays.toString(projects) +
                '}';
        
    }
}
