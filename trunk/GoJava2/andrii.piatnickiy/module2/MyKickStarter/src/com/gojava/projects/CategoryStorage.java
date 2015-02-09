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

    // TODO Удалить
    public void display() {
        for (Category category : categoryStorageList) {
            out.print(getCategoryToString(category));
            // out.print(out.printCategory(category));
        }
    }

    public String getCategoryToString(Category category) {
        return category.toString();

    }

    public Category getCategory(int index) {
        return categoryStorageList.get(index);
    }

}
