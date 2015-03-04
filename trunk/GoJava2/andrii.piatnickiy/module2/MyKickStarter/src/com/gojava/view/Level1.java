package com.gojava.view;

import com.gojava.projects.CategoryStorage;

public class Level1 implements Level {
    private CategoryStorage categoryStorage;
    private int position = 1;

    public Level1(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    public String displayMySelf(int currentPosition) {
        return categoryStorage.getCategoryToString();
    }

    @Override
    public int getPosition() {
        return position;
    }


}
