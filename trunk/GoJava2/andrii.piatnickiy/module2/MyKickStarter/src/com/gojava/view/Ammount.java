package com.gojava.view;

import java.util.Scanner;

import com.gojava.projects.Project;
import com.gojava.projects.ProjectStorage;

public class Ammount {
    private Menu menu;
    private ProjectStorage projectStorage;
    String description;
    int sum;

    public Ammount(int sum, Menu menu, ProjectStorage projectStorage) {
        this.menu = menu;
        this.projectStorage = projectStorage;
        this.sum = sum;
        setDescription();
    }

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

    public void setProjectSum(int sum, int choose) {
        if (choose == 0) {
            String ammountMessage = "Please, enter your ammount";
            System.out.println(ammountMessage);
            Scanner scanner = new Scanner(System.in);
            sum = scanner.nextInt();
        }
        Project project = projectStorage.getSpecificProject(
                menu.currentCategory, menu.currentProject);
        project.setCurrentSum(sum + project.getCurrentSum());
    }

}
