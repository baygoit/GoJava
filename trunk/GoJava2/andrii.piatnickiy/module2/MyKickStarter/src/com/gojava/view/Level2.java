package com.gojava.view;

import com.gojava.input.Out;
import com.gojava.projects.ProjectManager;

public class Level2 implements Level {
    Out out = new Out(); 
    private ProjectManager manager;
    private int position = 2;

    public Level2(ProjectManager manager) {
        this.manager = manager;
    }

    public void displayMySelf(int categoryNumber) {
        //TODO
//        out.printProjectPreview(project);manager.displayProjects(categoryNumber);
        manager.displayProjects(categoryNumber);
    }

    @Override
    public int getPosition() {
        return position;
    }

}
