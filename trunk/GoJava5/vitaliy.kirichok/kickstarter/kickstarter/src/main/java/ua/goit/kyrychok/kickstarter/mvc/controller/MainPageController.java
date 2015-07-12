package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;
import ua.goit.kyrychok.kickstarter.mvc.view.MainPageView;

public class MainPageController {
    private MainPageModel model;
    private MainPageView view;

    public MainPageController(MainPageModel model, MainPageView view) {
        this.model = model;
        this.view = view;
    }

    public boolean updateModel() {
        model.update();
        view.render(model);
        return true;
    }
}
