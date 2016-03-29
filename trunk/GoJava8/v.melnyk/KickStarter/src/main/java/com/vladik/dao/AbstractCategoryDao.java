package com.vladik.dao;

import java.util.List;

import com.vladik.model.Category;

public abstract class AbstractCategoryDao {

    public final String SEMICOLON_DELIMITER = ";";
    public final String NEW_LINE_SEPARATOR = "\n";

    public abstract void add(Category element);

    public abstract void remove(Category element);

    public abstract List<Category> getAll();

    public abstract int getSize();
}
