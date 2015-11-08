package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.view.MainPageView;


/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class MainPageController {
    private LocationManager locationManager;
    private MainPageView view;
    private CategoryModel model;

    public MainPageController(MainPageView view, CategoryModel categoryModel) {
        this.view = view;
        this.model = categoryModel;
    }

    public void start(int[] path) {

        model.refreshListModel();
        view.render(model);

        path[0] = Integer.parseInt(view.getInput());
        locationManager.setPath(path);
        locationManager.dispatch();
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }


}
