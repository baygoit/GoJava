package com.gojava.view;

import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectManager;

public class Level1 implements Level {
    CategoryStorage categoryStorage;
//    private ProjectManager manager;
    private int position = 1;

    public Level1(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }


    public void displayMySelf(int currentPosition) {
//        manager.displayCategories();
        categoryStorage.display();
    }

    @Override
    public int getPosition() {
        return position;
    }

}
