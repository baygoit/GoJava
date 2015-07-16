package goit.vh.kickstarter;

import goit.vh.kickstarter.model.Project;
import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.ProjectController;
import goit.vh.kickstarter.mvc.controller.MainPageController;

/**
 * Created by Viktor on 14.07.2015.
 */
public class LocationManager {

    // FIXME: LocationManager will eventually throw StackOverFlowError. Dispatch using while loop to avoid.
    private int inputIndex;
    private  MainPageController mainPageController;
    private CategoryController categoryController;
    private ProjectController projectController;
    private DataRegistry dataRegistry;
    private int[] path = {0,0};

    public LocationManager(MainPageController mainPageController, CategoryController categoryController) {
        this.mainPageController = mainPageController;
        this.categoryController = categoryController;

    }
    public LocationManager(MainPageController mainPageController, CategoryController categoryController,
                           ProjectController projectController) {
        this.mainPageController = mainPageController;
        this.categoryController = categoryController;
        this.projectController = projectController;
    }

    public void onApplicationStart(){
        mainPageController.start();

    }

    public void categoryControllerStart() {
        path[0] = inputIndex;
        categoryController.start(path);
    }
    public void listOfProjectsStart(int input) {
        path[0] = input;
        projectController.setDataRegistry(dataRegistry);
        projectController.start(path);
        

    }
    
    public void dispatch(int[] path){
    	if(path[0]==0 && path[1]==0){
    		mainPageController.start();
    	if(path[0]!=0 && path[1]==0){
    		categoryController.start(path);
    	}
    	if(path[0]!=0 && path[1]!=0){
    		projectController.start(path);
    	}
    	}
    }
//    private boolean updatePath(int inputIndex) {
//        if (inputIndex != 0) {
//            for (int i = 0; i < path.length; i++) {
//                if (path[i] == 0) {
//                    path[i] = inputIndex;
//                    return true;
//                }
//            }
//        } else {
//            for (int i = path.length - 1; i <= 0; i--) {
//                if (path[i] != 0) {
//                    path[i] = inputIndex;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    public void setInputIndex(int inputIndex) {
        this.inputIndex = inputIndex;
    }

    public void setDataRegistry(DataRegistry dataRegistry){
        this.dataRegistry = dataRegistry;
    }
	public void setPath(int[] path) {
		this.path = path;
		
	}

}
