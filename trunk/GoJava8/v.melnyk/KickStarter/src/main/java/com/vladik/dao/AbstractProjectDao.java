package com.vladik.dao;

import java.util.List;

import com.vladik.model.Category;
import com.vladik.model.Project;

public abstract class AbstractProjectDao {

    public final String SEMICOLON_DELIMITER = ";";
    public final String NEW_LINE_SEPARATOR = "\n";

    public abstract void add(Project element);

    public abstract void remove(Project element);

    public abstract List<Project> getAll();

    public abstract int getSize();

    public abstract List<Project> getProjectsFromCategory(Category category);

}
