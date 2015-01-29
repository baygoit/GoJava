package com.gojava.view;

import java.util.ArrayList;

import com.gojava.projects.ProjectManager;

public class Menu {
    ProjectManager manager = new ProjectManager();
    private int currentLevelPosition;
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;
    int categoryPosition;

    private ArrayList<Level> levelsList = new ArrayList<>();

    public Menu() {
        this.level1 = new Level1(manager);
        this.level2 = new Level2(manager);
        this.level3 = new Level3(manager);
        level3.setMenu(this);
        levelsList.add(level1);
        levelsList.add(level2);
        levelsList.add(level3);
        initMenu();
    }

    public void initMenu() {
        currentLevelPosition = 1;
        level1.displayMySelf(currentLevelPosition);
    }

    public void nextLevel(int nubberForNextLevel) {
        if (nubberForNextLevel == 0) {
            currentLevelPosition--;
            if (currentLevelPosition == 2) {
                displayCurrentLevel(categoryPosition);
            } else {
                displayCurrentLevel(nubberForNextLevel);
            }
        } else {
            currentLevelPosition++;
            if (currentLevelPosition == 2) {
                categoryPosition = nubberForNextLevel;
            }
            displayCurrentLevel(nubberForNextLevel);
        }

    }

    private void displayCurrentLevel(int nubberForNextLevel) {
        for (Level level : levelsList) {
            if (currentLevelPosition == level.getPosition()) {
                level.displayMySelf(nubberForNextLevel);
            }
        }
    }
}
