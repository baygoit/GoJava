package com.gojava.view;

import com.gojava.projects.ProjectManager;

public class Level1 implements Level {
    private ProjectManager manager;
    private int position = 1;

    public Level1(ProjectManager manager) {
        this.manager = manager;
    }

    public void displayMySelf(int currentPosition) {
        manager.displayCategories();
    }

    @Override
    public int getPosition() {
        return position;
    }

}
