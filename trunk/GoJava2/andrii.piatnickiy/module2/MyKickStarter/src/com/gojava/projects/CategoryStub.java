package com.gojava.projects;

public class CategoryStub implements ICategory{
    public CategoryStub() {
        this.name = "stubName";
        this.categoryId = 0;
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
