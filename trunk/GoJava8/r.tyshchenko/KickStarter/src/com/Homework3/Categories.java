package com.Homework3;

/**
 * Created by roman on 06.03.16.
 */
public class Categories {
    private Category[] categories = new Category[10];

    public int count = 0;

    public void add(Category category) {
        categories[count] = category;
        count++;
    }

    public String[] getCategories() {
        String[] rezalt = new String[count];
        for (int index = 0; index < count; index++) {
            rezalt[index] = String.valueOf(index+1) + " - " + categories[index].getName();
        }
        return rezalt;
    }

    public Category get(int index) {
        return categories[index];
    }

    public int size() {
        return count;
    }
}
