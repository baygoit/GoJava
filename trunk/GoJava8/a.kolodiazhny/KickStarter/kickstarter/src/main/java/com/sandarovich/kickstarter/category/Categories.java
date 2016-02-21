package com.sandarovich.kickstarter.category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olexander Kolodiazhny
 */
public class Categories {

    private final List<Category> categories = new ArrayList<Category>();

    public Category get(int index) {
        return categories.get(index);
    }

    public void add(Category category) {
        categories.add(category);
    }

    public int size() {
        return categories.size();
    }
}
