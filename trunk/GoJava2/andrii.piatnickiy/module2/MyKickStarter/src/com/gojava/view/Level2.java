package com.gojava.view;

import com.gojava.inputOutput.ConsoleIO;
import com.gojava.projects.ProjectStorage;

public class Level2 implements Level {
    private int position = 2;
    private ProjectStorage projectStorage;
    private ConsoleIO out;

    public Level2(ProjectStorage projectStorage, ConsoleIO out) {
        this.projectStorage = projectStorage;
        this.out = out;
    }

    public void displayMySelf(int categoryNumber) {
        out.print(projectStorage.getAll(categoryNumber));
    }

    @Override
    public int getPosition() {
        return position;
    }

}
