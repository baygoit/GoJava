package com.gojava.view;

import com.gojava.projects.ProjectManager;

public class Level3 implements Level {
    private Menu menu;
    private ProjectManager manager;
    private int position = 3;

    public Level3(ProjectManager manager) {
        this.manager = manager;
    }

    @Override
    public void displayMySelf(int nubberForNextLevel) {
        manager.displaySpecificProject(menu.categoryPosition,
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
