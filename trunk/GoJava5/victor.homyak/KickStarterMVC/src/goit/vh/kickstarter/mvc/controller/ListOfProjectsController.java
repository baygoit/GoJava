package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.ListOfProjectsModel;
import goit.vh.kickstarter.mvc.view.ListOfProjectsView;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ListOfProjectsController {

    private ListOfProjectsModel listOfProjectsModel;
    private ListOfProjectsView listOfProjectsView;
    private LocationManager locationManager;

    public ListOfProjectsController(ListOfProjectsView listOfProjectsView,ListOfProjectsModel listOfProjectsModel){
        this.listOfProjectsModel = listOfProjectsModel;
        this.listOfProjectsView = listOfProjectsView;
    }

    public void start(int inputIndex) {
        listOfProjectsModel.refreshModel(inputIndex);
        listOfProjectsView.render(listOfProjectsModel);
    }
}
