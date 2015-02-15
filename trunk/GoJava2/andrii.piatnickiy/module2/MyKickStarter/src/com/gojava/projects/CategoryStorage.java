package com.gojava.projects;

public interface CategoryStorage {

    public void add(String name, int categoryId);

    public String getCategoryToString();

    public Category getCategory(int index);

}
