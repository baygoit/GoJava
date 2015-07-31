package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.Output;


import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryModel {
    private DataRegistry dataRegistry;
    private String categoryName;
    private int categoryIndex;
    private Map<Integer, ArrayList<ProjectModel>> categories;
    private Output output = new Output();

    public void refreshModel(int input) {

        if (getCategories().size() < input - 1) {
            output.println("You choose not sutable variant, try more.");
        //    return null;categoryIndex =
            categoryIndex = 0;
            categoryName ="";
        } else {
            categoryIndex = dataRegistry.getProjectList(input).get(0).getParentId();
            categoryName = dataRegistry.getProjectList(input).get(0).getParentName();
          //  return 1;
        }
    }

    public void refreshListModel(){
        this.categories = dataRegistry.getCategories();
    }


    public Map<Integer, ArrayList<ProjectModel>> getCategories() {
        return categories;
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
