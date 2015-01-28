package View;

import java.util.ArrayList;

import com.gojava.projects.ProjectManager;

public class Menu {
    ProjectManager manager = new ProjectManager();
    private int currentPosition = 1;
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
    }
    public void initMenu(){
        level1.displayMySelf(currentPosition);
    }
    // TODO bugs is still
    public void nextLevel(int nubberForNextLevel) {
        if (nubberForNextLevel == 0) {
            levelUp(parrentLevelPositon);

        } else {
            levelDown(nubberForNextLevel);
            parrentLevelPositon = nubberForNextLevel;
        }

    }

    private void levelUp(int nubberForNextLevel) {
        currentPosition--;
        for (Level level : levelsList) {
            System.out.println();
            if (currentPosition == level.getPosition()) {
                level.displayMySelf(nubberForNextLevel);
            }
        }
    }

    private void levelDown(int nubberForNextLevel) {
        currentPosition++;
        for (Level level : levelsList) {
            System.out.println();
            if (currentPosition == level.getPosition()) {
                level.displayMySelf(nubberForNextLevel);
            }
        }
    }
}
