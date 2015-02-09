package com.gojava.projects;

import java.util.ArrayList;

import com.gojava.inputOutput.*;

public class CategoryStorage {
    Out out;

    public void setOut(Out out) {
        this.out = out;
    }

    private ArrayList<Category> categoryStorageList = new ArrayList<Category>();

    public void add(String name, int categoryId) {
        categoryStorageList.add(new Category(name, categoryId));
    }


    public String  getCategoryToString() {
        StringBuffer sb = new StringBuffer();
        for (Category category : categoryStorageList) {
            sb.append(category.toString()).append("\n");
        }
        return sb.toString();
    }


    public Category getCategory(int index) {
        return categoryStorageList.get(index);
    }

}
