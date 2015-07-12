package goit.dm.kickstarter;

import goit.dm.kickstarter.DataRegistry;
import goit.dm.kickstarter.model.Category;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/12/15
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataRegistryTest {

    @Test
    public void whenGetMsgThanReturnNotNull() throws Exception {
        DataRegistry dataRegistry = new DataRegistry();

        String result = dataRegistry.getHelloMsg();

        Assert.assertNotNull("Hello msg must not be null", result);
    }


    @Test
    public void wenGetMsgThanReturnSomeStr() throws Exception {
        DataRegistry dataRegistry = new DataRegistry();

        String result = dataRegistry.getHelloMsg();

        Assert.assertTrue("Hello msg must not be empty", result.trim().length() > 0);
    }

    @Test
    public void whenGetCategoriesThanReturnNotNull() throws Exception {
        DataRegistry dataRegistry = new DataRegistry();

        Category[] result = dataRegistry.getCategories();

        Assert.assertNotNull("Categories array must not be null", result);
    }


    @Test
    public void whenRegisterCategoriesThanReturnSameCategories() throws Exception {
        DataRegistry dataRegistry = new DataRegistry();
        Category[] categories = {new Category("Category 1"), new Category("Category 2"), new Category("Category 3")};
        dataRegistry.registerCategories(categories);

        Category[] result = dataRegistry.getCategories();

        Assert.assertArrayEquals("Categories must be the same as registered", categories, result);
    }

}
