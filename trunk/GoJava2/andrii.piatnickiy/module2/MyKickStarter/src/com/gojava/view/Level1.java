package com.gojava.view;

import com.gojava.projects.CategoryStorage;

public class Level1 implements Level {
    CategoryStorage categoryStorage;
    private int position = 1;

    public Level1(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    public void displayMySelf(int currentPosition) {
        categoryStorage.display();
    }

    @Override
    public int getPosition() {
        return position;
    }

}
