package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.ProjectController;
import goit.vh.kickstarter.mvc.controller.MainPageController;

/**
 * Created by Viktor on 14.07.2015.
 */
public class LocationManager {

    // FIXME: LocationManager will eventually throw StackOverFlowError. Dispatch using while loop to avoid.

    private MainPageController mainPageController;
    private CategoryController categoryController;
    private ProjectController projectController;
    private int[] path = {0, 0};

    public LocationManager(MainPageController mainPageController, CategoryController categoryController,
                           ProjectController projectController) {
        this.mainPageController = mainPageController;
        this.categoryController = categoryController;
        this.projectController = projectController;
    }

    public void dispatch() {
        if (path[0] == 0 && path[1] == 0) {
            mainPageController.start(path);
        }
        if (path[0] != 0 && path[1] == 0) {
            categoryController.start(path);
        }
        if (path[0] != 0 && path[1] != 0) {
            projectController.start(path);
        }

    }

    public void setPath(int[] path) {
        this.path = path;

    }

}
