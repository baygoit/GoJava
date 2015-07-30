package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.view.MainPageView;


/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class MainPageController {
    private LocationManager locationManager;
    private MainPageView view;
    private DataRegistry dataRegistry;

    public MainPageController(MainPageView view) {
        this.view = view;
    }

    public void start(int[] path) {
        view.render(dataRegistry);

        path[0] = Integer.parseInt(view.getInput());
        locationManager.setPath(path);
        locationManager.dispatch();
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

}
