package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.InputListener;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.view.MainPageView;


/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class MainPageController {
    private LocationManager locationManager;
    private MainPageView view;
    private MainPageModel model;

    public MainPageController(MainPageView view, MainPageModel model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        view.render(model);
        view.readUserInput();
        String userInput = view.getInput();
        int index = Integer.parseInt(userInput);
        locationManager.setInputIndex(index);
        locationManager.categoryControllerStart();
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }


}
