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

    // TODO перенести вывод в manager
    public void display() {
        for (Category category : categoryStorageList) {
            out.print(out.printCategory(category));
        }
    }

    public Category get() {
        for (Category category : categoryStorageList){
            return category;
        }
        return null;
    }

}
