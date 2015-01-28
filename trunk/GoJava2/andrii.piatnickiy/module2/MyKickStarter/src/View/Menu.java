package View;

import java.util.ArrayList;

import com.gojava.projects.ProjectManager;

public class Menu {
    ProjectManager manager = new ProjectManager();
    public int currentPosition = 1;
    public Level1 level1;
    public Level2 level2;
    public Level3 level3;
    int parrentLevelPositon;

    public ArrayList<Level> levelsList = new ArrayList<>();

    public Menu() {
        this.level1 = new Level1(manager, this);
        this.level2 = new Level2(manager, this);
        this.level3 = new Level3(manager, this);
        levelsList.add(level1);
        levelsList.add(level2);
        levelsList.add(level3);
    }
//TODO bugs is still
    public void nextLevel(int nubberForNextLevel) {
        if (nubberForNextLevel == 0) {
            levelUp(parrentLevelPositon);

        } else {
            levelDown(nubberForNextLevel);
        }
        parrentLevelPositon = nubberForNextLevel;
    }

    public void levelUp(int nubberForNextLevel) {
        currentPosition--;
        for (Level level : levelsList) {
            System.out.println();
            if (currentPosition == level.getPosition()) {
                level.displayMySelf(nubberForNextLevel);
            }
        }
    }

    public void levelDown(int nubberForNextLevel) {
        currentPosition++;
        for (Level level : levelsList) {
            System.out.println();
            if (currentPosition == level.getPosition()) {
                level.displayMySelf(nubberForNextLevel);
            }
        }
    }
}
