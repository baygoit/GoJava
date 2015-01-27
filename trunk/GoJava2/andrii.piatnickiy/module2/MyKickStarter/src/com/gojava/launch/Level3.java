package com.gojava.launch;

import com.gojava.projects.ProjectManager;

public class Level3 implements Level {
    ProjectManager manager;
    int position = 3;
    Menu menu;

    public Level3(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    public void displayMySelf(int categoryNumber, int currentPosition) {

        menu.currentPosition = initPosition(currentPosition);
    }

    public int initPosition(int currentPosition) {
        return currentPosition = position;
    }

    @Override
    public void displayMySelf(int currentPosition) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getPosition() {
        return position;
    }
}
