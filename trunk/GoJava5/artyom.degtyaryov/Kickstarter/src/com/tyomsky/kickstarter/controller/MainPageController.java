package com.tyomsky.kickstarter.controller;

import com.tyomsky.kickstarter.model.MainPageModel;
import com.tyomsky.kickstarter.view.AbstractView;


public class MainPageController extends AbstractController{

    private MainPageModel model;

    public MainPageController(AbstractView view, MainPageModel model) {
        super(view);
        this.model = model;
    }

    public void showModel(int... parameters){
        if (parameters[0] == 0) {
            currentIndex = 0;
        }
        model.update();
        view.show();
    }

    public void processInput(int input) {
        AbstractController child = getChild();
        if (currentIndex == 0) {
            if (input == 0) {
                System.exit(0);
            } else {
                currentIndex = input;
                child.showModel(input);
            }
        } else {
            child.processInput(input);
        }
    }

}
