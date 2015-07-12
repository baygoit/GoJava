package goit.dm.kickstarter;

import goit.dm.kickstarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataRegistry {

    private static final String DEFAULT_HELLO_MSG = "Hello on KickStarter";

    private Category[] categories = new Category[0];

    public String getHelloMsg() {
         return DEFAULT_HELLO_MSG;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void registerCategories(Category[] categories) {
        this.categories = categories;
    }

}
