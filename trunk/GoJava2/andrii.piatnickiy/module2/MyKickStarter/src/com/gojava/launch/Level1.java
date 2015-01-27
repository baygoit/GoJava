package com.gojava.launch;

import com.gojava.projects.ProjectManager;

public class Level1 implements Level {
    ProjectManager manager;
    int position = 1;

    Menu menu;

    public Level1(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    public void displayMySelf(int currentPosition) {
        manager.displayCategories();
    }

    public int initPosition(int currentPosition) {
        return currentPosition = position;
    }
    
    @Override
    public int getPosition() {
        return position;
    }
}
