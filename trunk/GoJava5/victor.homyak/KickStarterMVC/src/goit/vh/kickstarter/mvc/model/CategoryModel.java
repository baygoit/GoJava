package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryModel {

    private DataRegistry dataRegistry;
    private String categoryName;
    private String categoryIndex;

    public CategoryModel(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }


    public void refreshModel(int input) {
        Category category = dataRegistry.getCategories()[input - 1];

        categoryIndex = String.valueOf(input);
        categoryName = category.getName();

    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryIndex() {
        return categoryIndex;
    }
}
