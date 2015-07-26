package goit.vh.kickstarter.mvc.controller;

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

    public MainPageController(MainPageView view, MainPageModel model) {
        this.view = view;
        this.model = model;
    }

    public void start(int[] path) {
        view.render(model);

        path[0] = Integer.parseInt(view.getInput());
        locationManager.setPath(path);
        locationManager.dispatch();
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }


}
