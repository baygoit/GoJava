package com.gojava.view;

import com.gojava.projects.Project;
import com.gojava.projects.ProjectStorage;

public class Ammount {
    Menu menu;
    ProjectStorage projectStorage;
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        if (sum == 0) {
            description = "Own payment method";
        } else {
            description = Integer.toString(sum);
        }

    }

    int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Ammount(int sum, Menu menu, ProjectStorage projectStorage) {
        this.menu = menu;
        this.projectStorage = projectStorage;
        this.sum = sum;
        setDescription();
    }
    
    public void setProjectSum(int sum){
        Project project = projectStorage.getSpecificProject(
                menu.currentCategory, menu.currentProject);
        project.setCurrentSum(sum + project.getCurrentSum());
    }
}
