package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.mvc.view.MainPageView;


public class MainPageController {

    private MainPageModel model;
    private MainPageView view;

    public MainPageController(MainPageView view, MainPageModel model) {
        this.view = view;
        this.model = model;
    }

    public boolean showModel(){
        boolean isShown = false;
        model.update();
        view.show(model);
        isShown = true;
        return isShown;
    }

}
