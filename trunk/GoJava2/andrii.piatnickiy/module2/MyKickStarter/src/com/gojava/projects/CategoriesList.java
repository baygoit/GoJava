package com.gojava.projects;

import java.util.ArrayList;

public class CategoriesList {
    private ArrayList<ProjectCategory> categoryList = new ArrayList<>();

    public CategoriesList() {
        categoryList.add(new ProjectCategory("Electronics", 1));
        categoryList.add(new ProjectCategory("Programming", 2));
        categoryList.add(new ProjectCategory("Devices", 3));
    }

    // public void addCategoryList() {
    // this.categoryList.add(new ProjectCategory());
    // }

    public void dispalyProjectCategories() {
        for (ProjectCategory p : this.categoryList) {
            System.out.println(p.number + " " + p.getName());
            
        }

    }

}
