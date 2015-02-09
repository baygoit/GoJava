package com.gojava.view;

import com.gojava.inputOutput.Out;
import com.gojava.projects.CategoryStorage;

public class Level1 implements Level {
    Out out = new Out();
    CategoryStorage categoryStorage;
    private int position = 1;

    public Level1(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    public void displayMySelf(int currentPosition) {
        out.print(categoryStorage.getCategoryToString());
    }

    @Override
    public int getPosition() {
        return position;
    }

}
