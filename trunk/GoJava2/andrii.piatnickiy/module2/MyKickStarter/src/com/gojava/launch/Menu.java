package com.gojava.launch;

import java.util.ArrayList;

import com.gojava.projects.ProjectManager;

public class Menu {
    ProjectManager manager = new ProjectManager();
    int currentPosition;
    Level1 level1;
    Level2 level2;
    Level3 level3;

    ArrayList<Level> levelsList = new ArrayList<>();

    public Menu() {
        this.level1 = new Level1(manager, this);
        this.level2 = new Level2(manager, this);
        this.level3 = new Level3(manager, this);
        levelsList.add(level1);
        levelsList.add(level2);
        levelsList.add(level3);
    }

    public void nextLevel(int nubberForNextLevel, ArrayList<Level> levelsList) {
        if (nubberForNextLevel == 0) {
            levelUp();
            currentPosition--;
        } else {
            levelDown(levelsList, nubberForNextLevel);
        }
    }

    public void levelUp() {
        //TODO will realise body
    }

    public void levelDown(ArrayList<Level> levelsList, int nubberForNextLevel) {
        currentPosition++;
        for (Level level : levelsList) {
//            System.out.println("level.getPosition() = " + level.getPosition());
            if(currentPosition == level.getPosition()){
                level.displayMySelf(nubberForNextLevel);
            }
        }
    }

}
