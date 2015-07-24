package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/12/15
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataRegistryTest {

    @Mock
    private  Map<Integer,ArrayList<ProjectModel>> mapOfArrayLists;

    @Mock
    private MainPageModel mainPageModel;
    @Mock
    private ProjectModel projectModel;

    @Mock
    private Output output;

    @Before
    public void setUpMocs() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void whenGetCategoriesThanReturnMapOfArray() throws Exception {
        when(mainPageModel.getCategories()).thenReturn(mapOfArrayLists);
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
