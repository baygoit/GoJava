package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class MainPageModel {

    private DataRegistry dataRegistry;

    public Map<Integer, ArrayList<ProjectModel>> getCategories() {
        return dataRegistry.getCategories();
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }
}
