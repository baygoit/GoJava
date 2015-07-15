package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.ListOfProjectsController;
import goit.vh.kickstarter.mvc.controller.MainPageController;

/**
 * Created by Viktor on 14.07.2015.
 */
public class LocationManager {

    // FIXME: LocationManager will eventually throw StackOverFlowError. Dispatch using while loop to avoid.
    private int inputIndex;
    private  MainPageController mainPageController;
    private CategoryController categoryController;
    private ListOfProjectsController listOfProjectsController;
    private int[] path = {0,0};

    public LocationManager(MainPageController mainPageController, CategoryController categoryController) {
        this.mainPageController = mainPageController;
        this.categoryController = categoryController;

    }
    public LocationManager(MainPageController mainPageController, CategoryController categoryController,
                           ListOfProjectsController listOfProjectsController) {
        this.mainPageController = mainPageController;
        this.categoryController = categoryController;
        this.listOfProjectsController = listOfProjectsController;
    }

    public void onApplicationStart(){
        mainPageController.start();

    }

    public void categoryControllerStart() {
        categoryController.start(inputIndex);
    }
    public void listOfProjectsStart() {
        listOfProjectsController.start(inputIndex);
    }

    private boolean updatePath(int inputIndex) {
        if (inputIndex != 0) {
            for (int i = 0; i < path.length; i++) {
                if (path[i] == 0) {
                    path[i] = inputIndex;
                    return true;
                }
            }
        } else {
            for (int i = path.length - 1; i <= 0; i--) {
                if (path[i] != 0) {
                    path[i] = inputIndex;
                    return true;
                }
            }
        }
        return false;
    }


    public void setInputIndex(int inputIndex) {
        this.inputIndex = inputIndex;
    }


}
