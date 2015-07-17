package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.ProjectView;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectController {

    private ProjectModel projectModel;
    private ProjectView projectView;
    private LocationManager locationManager;
    private DataRegistry dataRegistry;

    public ProjectController(ProjectView projectView, ProjectModel projectModel) {
        this.projectModel = projectModel;
        this.projectView = projectView;
    }

    public void start(int[] path) {
        if (path[0]!=0&& path[1]==0) {
            projectModel.refreshListModel(path[0]);
            projectView.renderList(projectModel);
            projectView.readUserInput();
            String userInput = projectView.getInput();
            int index = Integer.parseInt(userInput);
            path[1]= index;
            if (index==0) {
                path[0] = 0;
            }
            locationManager.setPath(path);
          
        }
        if (path[0]!=0&& path[1]!=0) {
            projectModel.refreshModel(path);
            projectView.render(projectModel);
            projectView.readInProjectUserInput();
            String userInput = projectView.getInput();
            int index = Integer.parseInt(userInput);
            path[1]= 0;
            if (index==0) {
                path[0] = 0;
            }
            locationManager.dispatch(path);
        }
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }
}
