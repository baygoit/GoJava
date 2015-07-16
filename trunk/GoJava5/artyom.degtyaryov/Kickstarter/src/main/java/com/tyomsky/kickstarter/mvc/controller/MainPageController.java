package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.mvc.view.MainPageView;


public class MainPageController extends AbstractController<MainPageModel, MainPageView> implements InputListener{


    public MainPageController(MainPageModel model, MainPageView view) {
        super(model, view);
    }

    @Override
    public void onInput(int... input) {
        model.update();
    }
}
