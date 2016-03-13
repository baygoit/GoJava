package com.sandarovich.kickstarter.category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olexander Kolodiazhny
 */
public class CategorySource {

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

    public void init() {
        add(new Category(1, "IT"));
        add(new Category(2, "Tourism"));
        add(new Category(3, "Garden"));
    }

    public String getAllCategories() {
        StringBuilder result = new StringBuilder();
        for (Category category : categories) {
            result.append(category.toString() + "\n");
        }
        return result.toString();
    }

    public Category getCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    public boolean isValidCategory(String category) {
        int categoryId = 0;
        try {
            categoryId = Integer.parseInt(category);
        } catch (Exception e) {
            return false;
        }
        if (getCategoryById(categoryId) == null) {
            return false;
        }
        return true;
    }

}
