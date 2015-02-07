package com.gojava.view;

import com.gojava.inputOutput.Out;
import com.gojava.projects.ProjectManager;
import com.gojava.projects.ProjectStorage;

public class Level2 implements Level {
    Out out = new Out(); 
    private ProjectManager manager;
    private int position = 2;
    private ProjectStorage projectStorage;

    
    public Level2(ProjectStorage projectStorage) {
        this.projectStorage = projectStorage;
    }

    public void displayMySelf(int categoryNumber) {
        //TODO
//        out.printProjectPreview(project);
//        manager.displayProjects(categoryNumber);
        projectStorage.getAll(categoryNumber);
    }

    @Override
    public int getPosition() {
        return position;
    }

}
