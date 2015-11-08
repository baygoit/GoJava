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
            try { // FIXME: instead of using exception, create method to get Categories size in model, and check
                  // categories size here. it will be faster, and easily understood.
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

class Path {
    private final int categoryId; // better to user either Integer and null, or even better, java 8 Option
    private final int projectId;

    public static final Path EMPTY = new Path(-1, -1);

    public Path(int categoryId, int projectId) {
        this.categoryId = categoryId;
        this.projectId = projectId;
    }

    public Path goToCategory(int id) {
        return new Path(id, -1);
    }

    public Path goToProject(int id) {
        return new Path(categoryId, projectId);
    }

    public Path returnToCategory() {
        return new Path(categoryId, -1);
    }

    public boolean isProjectDefined() {
        return projectId != -1;
    }

    public boolean isCategoryDefined() {
        return categoryId != -1;
    }

    public Path goToMainScreen() {
        return EMPTY;
    }

    public static void exampleUsage() {
        Path p = Path.EMPTY;
        // user has clicked category 5:
        Path p1 = p.goToCategory(5);
    }
}