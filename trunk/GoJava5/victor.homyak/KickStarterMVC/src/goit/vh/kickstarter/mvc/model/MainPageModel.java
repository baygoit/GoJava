package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class MainPageModel {

    private DataRegistry dataRegistry;

    public Category[] getCategories() {
        return dataRegistry.getCategories();
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }
}
