package com.gojava.projects;

import java.util.ArrayList;

public class CategoriesList {

    ArrayList<ProjectCategory> categoryList = new ArrayList<>();

    public void addCategoryList() {
        categoryList.add(new ProjectCategory());
    }

    public void dispalyProjectCategories() {
        for (ProjectCategory p : categoryList) {
            System.out.println(p.getDesc());
        }

    }
}
