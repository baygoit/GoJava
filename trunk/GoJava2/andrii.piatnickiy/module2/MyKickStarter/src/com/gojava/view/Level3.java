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
    public String displayMySelf(int nubberForNextLevel) {
        return projectStorage.getSpecificProject(menu.categoryPosition,
                nubberForNextLevel);
    }
//TODO переделать. так не должно быть
    public String displayMySelf(int nubberForNextLevel, int categoryPosition) {
       return projectStorage.getSpecificProject(categoryPosition,
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
