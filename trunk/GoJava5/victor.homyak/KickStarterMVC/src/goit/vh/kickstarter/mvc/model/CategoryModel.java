package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryModel {

    private DataRegistry dataRegistry;
    private String categoryName;
    private String categoryIndex;
    private Output output = new Output();

    public CategoryModel(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public Object refreshModel(int input) {
        if (dataRegistry.getCategories().length < input - 1) {
            output.println("You choose not sutable variant, try more.");
            return null;
        } else {
            Category category = dataRegistry.getCategories()[input - 1];
            categoryIndex = String.valueOf(input);
            categoryName = category.getName();
            return 1;
        }
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryIndex() {
        return categoryIndex;
    }
}
