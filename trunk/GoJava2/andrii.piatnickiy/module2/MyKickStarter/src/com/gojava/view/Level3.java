package com.gojava.view;

import com.gojava.inputOutput.ConsoleIO;
import com.gojava.projects.ProjectStorage;

public class Level3 implements Level {
    private Menu menu;
    private int position = 3;
    private ProjectStorage projectStorage;
    private ConsoleIO out;

    public Level3(ProjectStorage projectStorage, ConsoleIO out) {
        this.projectStorage = projectStorage;
        this.out = out;
    }

    @Override
    public void displayMySelf(int nubberForNextLevel) {
       out.print(projectStorage.getSpecificProject(menu.categoryPosition,
               nubberForNextLevel));
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int getPosition() {
        return position;
    }

}
