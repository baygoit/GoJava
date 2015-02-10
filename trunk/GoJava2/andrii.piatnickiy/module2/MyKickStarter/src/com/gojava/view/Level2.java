package com.gojava.view;

import com.gojava.inputOutput.IO;
import com.gojava.projects.ProjectStorage;

public class Level2 implements Level {
    private int position = 2;
    private ProjectStorage projectStorage;
    private IO out;

    public Level2(ProjectStorage projectStorage, IO out) {
        this.projectStorage = projectStorage;
        this.out = out;
    }

    public String displayMySelf(int categoryNumber) {
        return projectStorage.getAll(categoryNumber);
    }

    @Override
    public int getPosition() {
        return position;
    }

}
