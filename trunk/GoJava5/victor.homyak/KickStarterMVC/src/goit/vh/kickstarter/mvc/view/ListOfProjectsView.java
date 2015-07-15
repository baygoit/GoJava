package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.model.Project;
import goit.vh.kickstarter.mvc.model.ListOfProjectsModel;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ListOfProjectsView {
    private String input;
    private Output output;

    public void render(ListOfProjectsModel listOfProjectsModel) {

        Project[] projects = listOfProjectsModel.getListOfProjectses();
        for (int i = 0; i < projects.length; i++) {
            output.println(String.valueOf(i + 1) + " " + projects[i].getName());
        }
    }
}
