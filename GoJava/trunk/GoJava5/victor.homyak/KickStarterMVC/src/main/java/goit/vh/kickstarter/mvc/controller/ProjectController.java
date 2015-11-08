package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.ProjectView;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectController {

    private ProjectModel projectModel;
    private ProjectView projectView;
    private LocationManager locationManager;
    private Output output = new Output();

    public ProjectController(ProjectView projectView, ProjectModel projectModel) {
        this.projectModel = projectModel;
        this.projectView = projectView;
    }

    public void start(int[] path) {
        if (path[0] != 0 && path[1] != 0) {
            projectModel.refreshModel(path);
            projectView.render(projectModel);
            projectView.readInProjectUserInput();
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
            }
            path[1] = 0;
            locationManager.dispatch();
        }
    }


    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }
}
