package com.gojava.projects;

public class ProjectCategory {
    String name;
    int number;
    static int preNumber = 0;
    

    ProjectCategory(String name, int number){
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }

}
