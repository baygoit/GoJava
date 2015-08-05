package goit.vh.kickstarter.mvc.controller;


import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.CategoryView;
import goit.vh.kickstarter.mvc.view.ProjectView;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryController {
    private ProjectModel projectModel;
    private LocationManager locationManager;
    private CategoryView view;
    private ProjectView projectView;
    private CategoryModel model;
    private Output output = new Output();

    public CategoryController(CategoryView view,
                              ProjectView projectView,
                              CategoryModel model,
                              ProjectModel projectModel) {
        this.view = view;
        this.model = model;
        this.projectView = projectView;
        this.projectModel = projectModel;
    }

    public void start(int[] path) {
        if (path[0] != 0 && path[1] == 0) {

            if (model.getCategories().size() < path[0] - 1) {
                path[0] = 0;
                output.println("You choose not sutable variant, try onese more!\n");
                locationManager.setPath(path);
                locationManager.dispatch();
            }
            try {
                model.refreshModel(path[0]);
            } catch (RuntimeException myException) {
                myException.toString();
                path[0] = 0;
                locationManager.setPath(path);
                locationManager.dispatch();
            }
            view.render(model);

            projectModel.refreshListModel(path[0]);

            projectView.renderList(projectModel.getListOfProjectses());

            path[1] = Integer.parseInt(projectView.getInput());

            if (path[1] == 0) {
                path[0] = 0;
                locationManager.setPath(path);
                locationManager.dispatch();
            }

            try {
                projectModel.refreshModel(path);
            } catch (IndexOutOfBoundsException ex) {
                output.println("You choose not sutable variant, try more.");
                path[1] = 0;
            }

            if (path[1] == 0) {
                path[0] = 0;
            }
            locationManager.dispatch();
            locationManager.setPath(path);
            locationManager.dispatch();
        }
        model.refreshModel(path[0]);
        locationManager.dispatch();
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

}
