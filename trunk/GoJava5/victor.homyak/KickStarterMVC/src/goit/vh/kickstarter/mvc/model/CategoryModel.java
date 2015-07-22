package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.Output;


import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryModel {
    private DataRegistry dataRegistry;
    private String categoryName;
    private int categoryIndex;
    private Output output = new Output();

    public Object refreshModel(int input) {
        if (dataRegistry.getCategories().size() < input - 1) {
            output.println("You choose not sutable variant, try more.");
            return null;
        } else {
            categoryIndex = dataRegistry.getProjectList(input).get(0).getParentId();
            categoryName = dataRegistry.getProjectList(input).get(0).getParentName();
            return 1;
        }
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }
}
