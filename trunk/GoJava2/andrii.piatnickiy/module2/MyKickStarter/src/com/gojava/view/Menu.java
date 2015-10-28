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
    private Level3 level3;
    private Level4 level4;

    private ArrayList<Level> levelsList = new ArrayList<>();
    public ClientInteraction clientInteraction;

    public Menu(CategoryStorage categoryStorage, ProjectStorage projectStorage,
            IO iO) {
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

    public void printNextLevel(int nubberForNextLevel) throws Exception {
        out.print(nextLevel(nubberForNextLevel));
    }

    public String nextLevel(int nubberForNextLevel) throws Exception {
        String result = "";
        try {
            if (nubberForNextLevel == 0 && currentLevelPosition == 1){
                MenuUpException menuUpException =  new MenuUpException(nubberForNextLevel);
                throw menuUpException;
            }else if (nubberForNextLevel > 0 && currentLevelPosition == 4){
                MenuDownException menuDownException = new MenuDownException(nubberForNextLevel);
                throw menuDownException;   
            }
            Level level;
            // TODO refactoring 
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
                // TODO refactoring 
                if (currentLevelPosition == 2) {
                    currentCategory = nubberForNextLevel;
                }
                if (currentLevelPosition == 3) {
                    currentProject = nubberForNextLevel;
                }
            }
            level = getCurrentLevel();
            result = level.displayMySelf(nubberForNextLevel);
        } catch (MenuUpException menuUpException) {
            System.err.println(menuUpException);
        } catch (MenuDownException menuDownException) {
            System.err.println(menuDownException);
        }

        return result;
    }

    private void add(Level level) {
        levelsList.add(level);
    }

    private void initMenu() {
        setCurrentLevelPosition(1);
        out.print(level1.displayMySelf(currentLevelPosition));
    }

    private Level getCurrentLevel() {
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
