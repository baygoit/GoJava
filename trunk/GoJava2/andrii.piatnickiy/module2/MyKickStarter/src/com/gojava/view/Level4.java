package com.gojava.view;

import java.util.Scanner;

import com.gojava.projects.Project;
import com.gojava.projects.ProjectStorage;

public class Level4 implements Level {
    Menu menu;
    private ProjectStorage projectStorage;
    private int position = 4;

    public Level4(ProjectStorage projectStorage) {
        this.projectStorage = projectStorage;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String displayMySelf(int categoryNumber) {
        menu.clientInteraction.interactions.get(categoryNumber - 1).displaySet();
//        name();
//        bankAccoun();
//        ammount();
        return "";
    }

    private void ammount() {
        String ammountMessage = "Please, enter your ammount";
        System.out.println(ammountMessage);
        Scanner scanner2 = new Scanner(System.in);
        int sum = scanner2.nextInt();
        Project project = projectStorage.getSpecificProject(
                menu.currentCategory, menu.currentProject);
        project.setCurrentSum(sum + project.getCurrentSum());
    }

    private void bankAccoun() {
        String bankAccountMessage = "Please, enter your bank account";
        System.out.println(bankAccountMessage);
        Scanner scanner1 = new Scanner(System.in);
        scanner1.nextInt();
    }

    private void name() {
        String nameMessage = "Please, enter your name";
        System.out.println(nameMessage);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    @Override
    public int getPosition() {
        return position;
    }
}
