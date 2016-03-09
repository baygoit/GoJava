package com.sandarovich.kickstarter.category;

import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016
 */
public class CategoriesBuilder {

    private final Categories categories;
    private int id;
    private String name;

    public CategoriesBuilder() {
        this.categories = new Categories();
    }

    public CategoriesBuilder forInt(int id) {
        this.id = id;
        return this;
    }

    public CategoriesBuilder andName(String name) {
        this.name = name;
        return this;
    }

    public CategoriesBuilder build() {
        categories.add(new Category(id, name));
        return this;
    }

    public void createAll(List<String> categories) {
        for (int index = 0; index < categories.size(); index++) {
            this.categories.add(new Category(index, categories.get(index)));
        }

    }

    public Categories get() {
        return this.categories;
    }
}
