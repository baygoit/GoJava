package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.model.ListOfProjects;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ListOfProjectsModel {

    private DataRegistry dataRegistry;

//    private String categoryName;
//    private String categoryIndex;

    public ListOfProjectsModel(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public ListOfProjects[] listOfProjects() {
        return dataRegistry.getListOfProjects();
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public void refreshModel(int input) {
        ListOfProjects[] listOfProjects = dataRegistry.getProject(input);

    }
}
