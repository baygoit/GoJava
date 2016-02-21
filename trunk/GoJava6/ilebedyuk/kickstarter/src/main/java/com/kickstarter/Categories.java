package com.kickstarter;

/**
 * Created by Игорь on 05.02.2016.
 */
public class Categories {
    private Category[] categories = new Category[10];
    private int count = 0;

    public void add(Category category) {
        categories[count] = category;
        count++;
    }

    public String[] getCategories(){
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = String.valueOf(i + 1) + " - " + categories[i].getName();
        }
        return result;
    }

    public Category get(int index) {
        return categories[index];
    }

    public int size() {
        return count;
    }
}
