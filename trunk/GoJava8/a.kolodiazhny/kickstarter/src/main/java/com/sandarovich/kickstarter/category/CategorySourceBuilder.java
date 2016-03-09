package com.sandarovich.kickstarter.category;

import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016
 */
public class CategorySourceBuilder {

    private final CategorySource categories;
    private int id;
    private String name;

    public CategorySourceBuilder() {
        this.categories = new CategorySource();
    }

    public CategorySourceBuilder forInt(int id) {
        this.id = id;
        return this;
    }

    public CategorySourceBuilder andName(String name) {
        this.name = name;
        return this;
    }

    public CategorySourceBuilder build() {
        categories.add(new Category(id, name));
        return this;
    }

    public void createAll(List<String> categories) {
        for (int index = 0; index < categories.size(); index++) {
            this.categories.add(new Category(index, categories.get(index)));
        }

    }

    public CategorySource get() {
        return this.categories;
    }
}
