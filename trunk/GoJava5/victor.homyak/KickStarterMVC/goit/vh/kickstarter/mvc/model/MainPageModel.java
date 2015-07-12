package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageModel {

    private DataRegistry dataRegistry;

    public String getHelloMsg() {
        return dataRegistry.getHelloMsg();
    }

    public Category[] getCategories() {
        return dataRegistry.getCategories();
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }
}
