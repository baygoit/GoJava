package com.gojava.projects;

import java.util.ArrayList;

public class CategoriesList {
    private ArrayList<ProjectCategory> categoryList = new ArrayList<>();

    public CategoriesList() {
        categoryList.add(new ProjectCategory("Sport", 1));
        categoryList.add(new ProjectCategory("Health", 2));
        categoryList.add(new ProjectCategory("Devices", 3));
    }

    public void dispalyProjectCategories() {
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println((i + 1) + " " + categoryList.get(i).getName());
        }

    }

    public void chooseProjectCategory(int i) {
        System.out.println("You choose progect " + this.categoryList.get(i - 1).getName());

    }

}
