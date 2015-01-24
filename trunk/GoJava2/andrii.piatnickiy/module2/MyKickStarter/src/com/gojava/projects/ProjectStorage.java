package com.gojava.projects;

import java.util.ArrayList;

public class ProjectStorage {
    ArrayList<Project> projectStorageList = new ArrayList<Project>();
    
    public ProjectStorage(){
        this.projectStorageList.add(new Project("Robot", "I'm robot", 1000, 10, "60", 1));
    }

    
    public void addToProjectList(){
        this.projectStorageList.add(new Project("Robot", "I'm robot", 1000, 10, "60", 1));
    }

}
