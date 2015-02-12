package com.gojava.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.gojava.projects.Project;
import com.gojava.projects.ProjectStorage;

public class InvestInteraction implements Interactionable {
    Menu menu;
    ProjectStorage projectStorage;

    public InvestInteraction(Menu menu, ProjectStorage projectStorage) {
        this.menu = menu;
        this.projectStorage = projectStorage;
        initAmmounts();

    }

    @Override
    public String description() {
        return "Invest in the project";
    }

    public void displayInteractionSet() {
        // name();
        // bankAccoun();
        displayAmmountType();
        choseAmmount();
    }

    ArrayList<Ammount> ammounts = new ArrayList<>();

    private void initAmmounts() {
        ammounts.add(new Ammount(0, menu, projectStorage));
        ammounts.add(new Ammount(1, menu, projectStorage));
        ammounts.add(new Ammount(10, menu, projectStorage));
        ammounts.add(new Ammount(40, menu, projectStorage));
    }

    private void displayAmmountType() {

        String ammountMessage = "";
        if (!ammounts.isEmpty()) {
            System.out
                    .println("You can choose automatic or your own payment method");
            for (int i = 0; i < ammounts.size(); i++) {
                ammountMessage += i + ") " + ammounts.get(i).description + "\n";
            }
        }
        System.out.println(ammountMessage);
        ammountMessage = "";
    }

    private void choseAmmount() {
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        Ammount ammount = ammounts.get(choose);
        ammount.setProjectSum(ammount.sum, choose);
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
}
