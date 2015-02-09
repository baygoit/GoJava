package com.gojava.view;

import com.gojava.inputOutput.Out;
import com.gojava.projects.ProjectStorage;

public class Level2 implements Level {
    private int position = 2;
    private ProjectStorage projectStorage;
    private Out out;

    public Level2(ProjectStorage projectStorage, Out out) {
        this.projectStorage = projectStorage;
        this.out = out;
    }

    public void displayMySelf(int categoryNumber) {
        out.print(projectStorage.getAll(categoryNumber));
//        projectStorage.getAll(categoryNumber);
    }

    @Override
    public int getPosition() {
        return position;
    }

}
