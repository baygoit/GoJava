package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.model.Project;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ListOfProjectsModel {

    private DataRegistry dataRegistry;
    private Project[] listOfProjectses;

    public ListOfProjectsModel(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public Project[] getListOfProjectses() {
        return listOfProjectses;
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public void refreshModel(int input) {
        listOfProjectses = dataRegistry.getProject(input);

    }
}
