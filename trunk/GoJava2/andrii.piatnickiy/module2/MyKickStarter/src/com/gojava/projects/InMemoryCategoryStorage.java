package com.gojava.projects;

import java.util.ArrayList;

public class InMemoryCategoryStorage implements CategoryStorage{
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


    @Override
    public ArrayList<Category> getList() {
        return categoryStorageList;
    }

}
