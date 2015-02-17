package com.gojava.projects;

import java.util.ArrayList;

public interface CategoryStorage {

    public void add(String name, int categoryId);

    public String getCategoryToString();

    public Category getCategory(int index);

    ArrayList<Category> getList();
}
