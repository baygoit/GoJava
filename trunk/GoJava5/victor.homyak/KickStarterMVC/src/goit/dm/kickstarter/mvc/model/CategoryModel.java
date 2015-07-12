package goit.dm.kickstarter.mvc.model;

import goit.dm.kickstarter.DataRegistry;
import goit.dm.kickstarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
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
