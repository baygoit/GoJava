package com.gojava.projects;

import java.util.ArrayList;

public class CategoriesList {
    private ArrayList<Category> categoryList = new ArrayList<>();

    public CategoriesList() {
        categoryList.add(new Category("Sport", 1));
        categoryList.add(new Category("Health", 2));
        categoryList.add(new Category("Devices", 3));
    }

    public void dispalyProjectCategories() {
        for (Category projectCategory : categoryList) {
            System.out.println(projectCategory.getCategoryId() + " " + projectCategory.getName());
        }

    }

    public void displaySpecificProjectCategory(int i) {
        System.out.println("You choose progect " + this.categoryList.get(i - 1).getName());
    }

    public Category getChhosedProjectCategory() {
        // TODO Auto-generated method stub
        return this.categoryList.get(0);
    }

    
}
