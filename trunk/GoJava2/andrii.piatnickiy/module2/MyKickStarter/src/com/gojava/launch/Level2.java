package com.gojava.launch;

import com.gojava.projects.ProjectManager;

public class Level2 implements Level {
    ProjectManager manager;
    int position = 2;
    Menu menu;

    public Level2(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    public void displayMySelf(int categoryNumber) {
        manager.displayProjects(categoryNumber);
    }
    
    public int initPosition(int currentPosition) {
        return currentPosition = position;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
