package goit.vh.kickstarter.mvc.controller;


import goit.vh.kickstarter.Input;
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
    private Input input;
    private Output output = new Output();

    public CategoryController(CategoryView view,
                              ProjectView projectView,
                              CategoryModel model,
                              ProjectModel projectModel) {
        this.view = view;
        this.model = model;
        this.projectView = projectView;
        this.projectModel = projectModel;
        this.input = new Input();
    }

    public void start(int[] path) {
        if (path[0] != 0 && path[1] == 0) {

            if (model.refreshModel(path[0]) == null) {
                path[0] = 0;
                locationManager.setPath(path);
                locationManager.dispatch();
            }
            view.render(model);
            if (projectModel.refreshListModel(path[0]) == null) {
                locationManager.dispatch();
            }
            projectModel.refreshListModel(path[0]);
            projectView.renderList(projectModel.getListOfProjectses());
            projectView.readUserInput();
            int index = Integer.parseInt(input.getInput());
            path[1] = index;
            if (projectModel.refreshModel(path) == null) {
                output.println("You choose not sutable variant, returning to previous menu\n");
                path[1] = 0;
            }
            // TODO exception
            if (index == 0) {
                path[0] = 0;
            }
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
