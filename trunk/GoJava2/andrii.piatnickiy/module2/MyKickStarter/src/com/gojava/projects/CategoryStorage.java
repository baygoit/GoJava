package com.gojava.projects;

import java.util.ArrayList;

public class CategoryStorage {
    private ArrayList<Category> categoryStorageList = new ArrayList<Category>();

    public void addToCategoryStorageList(String name, int categoryId) {
        categoryStorageList.add(new Category(name, categoryId));
    }

    public void dispalyCategoryStorageList() {
        for (Category projectCategory : categoryStorageList) {
            System.out.println(projectCategory.getCategoryId() + " " + projectCategory.getName());
        }
    }
    
    public void displayChoosedCategory(int i){
        System.out.println("You choosed progect " + categoryStorageList.get(i - 1).getName());
    }
}
