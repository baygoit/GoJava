package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.controller.AbstractController;
import com.tyomsky.kickstarter.ui.Input;

public class Kickstarter {

    private AbstractController mainController;
    private Input input;

    public Kickstarter(Input input, AbstractController mainController) {
        this.input = input;
        this.mainController = mainController;
    }

    public void run() {
        mainController.showModel(0);
        int userChoice;
        while (true) {
            userChoice = input.getUserChoice();
            mainController.processInput(userChoice);
        }
    }

}