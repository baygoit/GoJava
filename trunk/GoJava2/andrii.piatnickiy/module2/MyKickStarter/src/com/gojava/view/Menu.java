package com.gojava.view;

import java.util.ArrayList;

import com.gojava.inputOutput.ConsoleIO;
import com.gojava.inputOutput.IO;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectStorage;

public class Menu {
    public IO out = new ConsoleIO();
    public int currentCategory;
    public int currentProject;
    private int currentLevelPosition;
    private Level1 level1;
    private Level2 level2;
    Level3 level3;
    Level4 level4;

    public IO iO;

    
    
    
    private ArrayList<Level> levelsList = new ArrayList<>();
    public ClientInteraction clientInteraction;

    public Menu(CategoryStorage categoryStorage, ProjectStorage projectStorage,
            IO iO) {
        this.iO = iO;
        this.level1 = new Level1(categoryStorage);
        this.level2 = new Level2(projectStorage);
        this.level3 = new Level3(projectStorage);
        this.level4 = new Level4();
        level3.setMenu(this);
        level4.setMenu(this);
        add(level1);
        add(level2);
        add(level3);
        add(level4);
        initMenu();
        this.clientInteraction = new ClientInteraction(this, projectStorage);
    }

    
    
    public void printNextLevel(int nubberForNextLevel) {
        out.print(nextLevel(nubberForNextLevel));
    }

    public String nextLevel(int nubberForNextLevel) {
        String result;
        if ((nubberForNextLevel == 0 && currentLevelPosition == 1)
                || (nubberForNextLevel > 0 && currentLevelPosition == 4)) {
            result = "not allowed to go below this level";
        } else {
            Level level;
            //TODO refactoring
            if (nubberForNextLevel == 0) {
                currentLevelPosition--;
                if (currentLevelPosition == 2) {
                    nubberForNextLevel = currentCategory;
                }
                if (currentLevelPosition == 3) {
                    nubberForNextLevel = currentProject;
                }
            } else {
                currentLevelPosition++;
              //TODO refactoring
                if (currentLevelPosition == 2) {
                    currentCategory = nubberForNextLevel;
                }
                if (currentLevelPosition == 3) {
                    currentProject = nubberForNextLevel;
                }
            }
            level = getCurrentLevel();
            result = level.displayMySelf(nubberForNextLevel);
        }
        return result;
    }

    public void add(Level level) {
        levelsList.add(level);
    }

    public void initMenu() {
        setCurrentLevelPosition(1);
        ;
        out.print(level1.displayMySelf(currentLevelPosition));
    }

    public Level getCurrentLevel() {
        Level result = null;
        for (Level level : levelsList) {
            if (currentLevelPosition == level.getPosition()) {
                result = level;
            }
        }
        return result;
    }

    public int getCategoryPosition() {
        return currentCategory;
    }

    public void setCategoryPosition(int categoryPosition) {
        this.currentCategory = categoryPosition;
    }

    public void setCurrentLevelPosition(int currentLevelPosition) {
        this.currentLevelPosition = currentLevelPosition;
    }
}
