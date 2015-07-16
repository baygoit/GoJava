package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.view.CategoryView;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryController {
    private LocationManager locationManager;
    private CategoryView view;
    private CategoryModel model;
    public CategoryController(CategoryView view,CategoryModel model){
        this.view = view;
        this.model = model;
    }

    public void start(int[] path){
        model.refreshModel(path[0]);
        view.render(model);
        locationManager.listOfProjectsStart(path[0]);
    }
    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

}
