package com.gojava.projects;

import java.util.ArrayList;

public class CategoryStorage {
    private ArrayList<Category> categoryStorageList = new ArrayList<Category>();

    public void add(String name, int categoryId) {
        categoryStorageList.add(new Category(name, categoryId));
    }

    public void display() {
        for (Category projectCategory : categoryStorageList) {
            System.out.println(projectCategory.toString());
        }
    }
    
}
