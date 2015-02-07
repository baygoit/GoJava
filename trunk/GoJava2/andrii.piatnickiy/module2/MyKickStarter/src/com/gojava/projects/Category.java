package com.gojava.projects;

public class Category{
    public Category(String name, int categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    private String name;
    private int categoryId;

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return categoryId + ") " + name;

    }
}
