package com.gojava.view;

import com.gojava.projects.ProjectStorage;

public class Level3 implements Level {
    private Menu menu;
    private int position = 3;
    private ProjectStorage projectStorage;

    public Level3(ProjectStorage projectStorage) {
        this.projectStorage = projectStorage;
    }

    @Override
    public void displayMySelf(int nubberForNextLevel) {
        projectStorage.getSpecificProject(menu.categoryPosition,
                nubberForNextLevel);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int getPosition() {
        return position;
    }

}
