package com.gojava.view;

import com.gojava.inputOutput.Out;
import com.gojava.projects.ProjectStorage;

public class Level3 implements Level {
    private Menu menu;
    private int position = 3;
    private ProjectStorage projectStorage;
    private Out out;

    public Level3(ProjectStorage projectStorage, Out out) {
        this.projectStorage = projectStorage;
        this.out = out;
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
