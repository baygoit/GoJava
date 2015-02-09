package com.gojava.view;

import java.util.ArrayList;

import com.gojava.inputOutput.Out;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectStorage;

public class Menu {
    Out out = new Out();
    private int currentLevelPosition;
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;
    int categoryPosition; 

    private ArrayList<Level> levelsList = new ArrayList<>();

    public Menu(CategoryStorage categoryStorage, ProjectStorage projectStorage) {
        this.level1 = new Level1(categoryStorage, out);
        this.level2 = new Level2(projectStorage, out);
        this.level3 = new Level3(projectStorage, out);
        level3.setMenu(this);
        add(level1);
        add(level2);
        add(level3);
        initMenu();
    }

    public void nextLevel(int nubberForNextLevel) {

        if ((nubberForNextLevel == 0 && currentLevelPosition == 1)
                || (nubberForNextLevel > 0 && currentLevelPosition == 3)) {
            System.out.println("not allowed to go below this level");
        } else {
            Level level;
            if (nubberForNextLevel == 0) {
                currentLevelPosition--;
                if (currentLevelPosition == 2) {
                    nubberForNextLevel = categoryPosition;
                }
            } else {
                currentLevelPosition++;
                if (currentLevelPosition == 2) {
                    categoryPosition = nubberForNextLevel;
                }
            }
            level = getCurrentLevel();
            level.displayMySelf(nubberForNextLevel);
        }
    }

    private void add(Level level) {
        levelsList.add(level);
    }

    public void initMenu() {
        currentLevelPosition = 1;
        level1.displayMySelf(currentLevelPosition);
    }

    public Level getCurrentLevel() {
        for (Level level : levelsList) {
            if (currentLevelPosition == level.getPosition()) {
                return level;
            }
        }
        return null;
    }
}
