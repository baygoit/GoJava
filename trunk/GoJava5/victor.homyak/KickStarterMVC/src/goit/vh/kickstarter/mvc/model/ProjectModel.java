package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.model.Project;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectModel {

    private DataRegistry dataRegistry;
    private Project[] listOfProjectses;
    private Project project;
    private String projectName;

    public ProjectModel(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public Project[] getListOfProjectses() {
        return listOfProjectses;
    }

    public void refreshModel(int[] path) {
        project = dataRegistry.getProject(path);
        this.projectName = project.getName();
    }

    public void refreshListModel(int input) {
        listOfProjectses = dataRegistry.getProjectList(input);

    }

    public String getProjectName() {
        return projectName;
    }

}

