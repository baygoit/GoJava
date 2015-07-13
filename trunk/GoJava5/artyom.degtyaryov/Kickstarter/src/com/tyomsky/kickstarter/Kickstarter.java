package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.mvc.controller.AbstractController;
import com.tyomsky.kickstarter.mvc.controller.MainPageController;
import com.tyomsky.kickstarter.ui.Input;

public class Kickstarter {

    private MainPageController controller;
    private Input input;

    public Kickstarter(Input input, MainPageController mainController) {
        this.input = input;
        this.controller = mainController;
    }

    public void run() {
        controller.onApplicationStart();
        int userChoice;
        while (true) {
            userChoice = input.getUserChoice();
            controller.processInput(userChoice);
        }
    }

}