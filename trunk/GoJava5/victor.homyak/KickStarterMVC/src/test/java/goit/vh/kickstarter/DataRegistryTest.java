package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/12/15
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataRegistryTest {

    @Test
    public void whenGetCategoriesThanReturnNotNull() throws Exception {
        DataRegistry dataRegistry = new DataRegistry();

        Map<Integer, ArrayList<ProjectModel>> result = dataRegistry.getCategories();

        Assert.assertNotNull("Categories array must not be null", result);
    }
//
//
    @Test
    public void whenRegisterCategoriesThanReturnSameCategories() throws Exception {
        DataRegistry dataRegistry = new DataRegistry();
        Map<Integer, ArrayList<ProjectModel>> categories = new HashMap<>();
        dataRegistry.registerCategories(categories);

        Map<Integer, ArrayList<ProjectModel>> result = dataRegistry.getCategories();

        Assert.assertEquals("Categories must be the same as registered", categories, result);
    }
//
}
