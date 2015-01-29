package View;

import java.util.ArrayList;

import com.gojava.projects.ProjectManager;

public class Menu {
    ProjectManager manager = new ProjectManager();
    private int currentPosition;
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;
    int parrentLevelPositon;

    private ArrayList<Level> levelsList = new ArrayList<>();

    public Menu() {
        this.level1 = new Level1(manager, this);
        this.level2 = new Level2(manager, this);
        this.level3 = new Level3(manager, this);
        levelsList.add(level1);
        levelsList.add(level2);
        levelsList.add(level3);
        initMenu();
    }

    public void initMenu() {
        currentPosition = 1;
        level1.displayMySelf(currentPosition);
    }

    // TODO bugs is still
    public void nextLevel(int nubberForNextLevel) {
        if (nubberForNextLevel == 0) {
            currentPosition--;
            currentLevel(nubberForNextLevel);
        } else {
            currentPosition++;
            currentLevel(nubberForNextLevel);
            if (currentPosition == 2) {
                parrentLevelPositon = nubberForNextLevel;
            }

        }

    }

    private void currentLevel(int nubberForNextLevel) {
        for (Level level : levelsList) {
            System.out.println();
            if (currentPosition == level.getPosition()) {
                level.displayMySelf(nubberForNextLevel);
            }
        }
    }
}
