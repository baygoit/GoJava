package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.LocationManager;
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
    private Input input = new Input();

    public MainPageController(MainPageView view, MainPageModel model) {
        this.view = view;
        this.model = model;
    }

    public void start(int[] path) {
        view.render(model);
        String userInput = input.getInput();
        int index = Integer.parseInt(userInput);
        path[0] = index;
        locationManager.dispatch();
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }


}
