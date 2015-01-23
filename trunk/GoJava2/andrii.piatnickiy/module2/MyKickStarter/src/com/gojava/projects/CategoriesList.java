package com.gojava.projects;

import java.util.ArrayList;

public class CategoriesList {
    ArrayList<ProjectCategory> categoryList = new ArrayList<>();
     public CategoriesList() {
        
        categoryList.add(new ProjectCategory());
        categoryList.add(new ProjectCategory());
        categoryList.add(new ProjectCategory());
    }

    public void addCategoryList() {
        this.categoryList.add(new ProjectCategory());
    }

    public void dispalyProjectCategories() {
         for (ProjectCategory p : this.categoryList) {
         System.out.println(p.getDesc());
         }
        
    }
    
}
