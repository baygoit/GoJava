package com.gojava.view;

import com.gojava.projects.ProjectManager;

public class Level2 implements Level {
    private ProjectManager manager;
    private int position = 2;

    public Level2(ProjectManager manager) {
        this.manager = manager;
    }

    public void displayMySelf(int categoryNumber) {
        manager.displayProjects(categoryNumber);
    }

    @Override
    public int getPosition() {
        return position;
    }

}
