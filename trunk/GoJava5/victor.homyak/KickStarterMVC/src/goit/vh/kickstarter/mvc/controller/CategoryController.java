package goit.vh.kickstarter.mvc.controller;


import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.view.CategoryView;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryController {
    private LocationManager locationManager;
    private CategoryView view;
    private CategoryModel model;

    public CategoryController(CategoryView view, CategoryModel model) {
        this.view = view;
        this.model = model;
    }

    public void start(int[] path) {
        model.refreshModel(path[0]);
        view.render(model);
        //path[1] = 1488;
        locationManager.goToListOfModels = true;

      //  projectController.start(path);
        locationManager.dispatch();
        //locationManager.listOfProjectsStart(path[0]);
        //locationManager.dispatch();
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

}
