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
    private Map<Integer, String> categories;
    private Output output = new Output();
    private RuntimeException myException;

    public void refreshModel(int input)throws RuntimeException{

        if (getCategories().size() < input) {
            output.println("You choose not sutable variant, try more.");
            categoryIndex = 0;
            categoryName = "";
            throw myException;
        } else {
            try {
                categoryIndex = dataRegistry.getProjectList(input).get(0).getParentId();
                categoryName = dataRegistry.getProjectList(input).get(0).getParentName();
            } catch (NullPointerException ex) {
                output.println("You choose not sutable variant, try more.");
                categoryIndex = 0;
                categoryName = "";
            }
        }
    }

    public void refreshListModel(){
        this.categories = dataRegistry.getCategories();
    }


    public Map<Integer, String> getCategories() {
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
