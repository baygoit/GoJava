package com.gojava.launch;

import com.gojava.projects.ProjectManager;

public class Level3 implements Level {
    ProjectManager manager;
    int position = 3;
    Menu menu;
    int parentPosition = 0;

    public Level3(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }


    public int initPosition(int currentPosition) {
        return currentPosition = position;
    }

    @Override
    public void displayMySelf(int projectNumber) {
        manager.displaySpecificProject(this.parentPosition, projectNumber);

    }

    @Override
    public int getPosition() {
        return position;
    }
}
