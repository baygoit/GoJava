package com.tyomsky.kickstarter.controller;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.view.*;
import com.tyomsky.kickstarter.view.EntityView;
import com.tyomsky.kickstarter.view.ViewFactory;
import com.tyomsky.kickstarter.view.ViewTypes;

public class Kickstarter {

    private ViewFactory viewFactory;
    private Input input;
    private Output output;
    private DataProvider dataProvider;

    public Kickstarter(Input input, Output output,  ViewFactory viewFactory, DataProvider dataProvider) {
        this.viewFactory = viewFactory;
        this.input = input;
        this.output = output;
        this.dataProvider = dataProvider;
    }

    public void run() {
        EntityView currentView = viewFactory.getView(ViewTypes.Main, dataProvider.getSomeQuote());
        int userChoice;
        while (true) {
            currentView.show(output);
            userChoice = input.getUserChoice(currentView.getMenuVariants());
            currentView = currentView.getChildView(userChoice);
            viewFactory.prepareNextView(currentView);
        }
    }

}