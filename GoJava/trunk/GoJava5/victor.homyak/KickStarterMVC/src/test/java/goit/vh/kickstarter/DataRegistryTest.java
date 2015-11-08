package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 */
public class DataRegistryTest {

    @Mock
    private Map<Integer, ArrayList<ProjectModel>> mapOfArrayLists;

    @Mock
    private ProjectModel projectModel;

    @Mock
    private CategoryModel categoryModel;

    @Mock
    private Output output;

    @Before
    public void setUpMocs() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void whenGetCategoriesThanReturnMapOfArray() throws Exception {
//        DataRegistry dataRegistry = new DataRegistry();
//
//        when(dataRegistry.getCategories()).thenReturn(mapOfArrayLists);
//
//    }

    //
//
//    @Test
//    public void whenRegisterCategoriesThanReturnSameCategories() throws Exception {
//        DataRegistry dataRegistry = new DataRegistry();
//        Map<Integer, ArrayList<ProjectModel>> categories = new HashMap<>();
//        dataRegistry.registerCategories(categories);
//
//        Map<Integer, ArrayList<ProjectModel>> result = categoryModel.getCategories();
//
//        Assert.assertEquals("Categories must be the same as registered", categories, result);
//    }

    @Test

    public void whenGetProjectList() throws Exception {

        DataRegistry dataRegistry = new DataRegistry();
        Map<Integer, ArrayList<ProjectModel>> categories = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);
        ArrayList<ProjectModel> category1 = new ArrayList<>();
        category1.add(new ProjectModel("Gluconazol -", "Brend new anabolics;", 25000000, 7500000, calendar.getTime(),
                "New MOC politics dictetes new requirements for pharmasy;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1));
        category1.add(new ProjectModel("Eczoskeleton -", "This thing upgrades muscle power;", 4000000, 2500000, calendar.getTime(),
                "Limites of human body was reached, but sport of big achievements  isn`t stopped;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1));
        ArrayList<ProjectModel> category2 = new ArrayList<>();
        category2.add(new ProjectModel("Warriors of eternity -", "New game, clone of 'Game of thrones';", 10000, 1500, calendar.getTime(),
                "Game of thrones was a very good game, but it starts to bore people, so new game is on!!;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        category2.add(new ProjectModel("Robo rally 2 -", "Reincarnation of good old strategy;", 7500, 3000, calendar.getTime(),
                "You will be able to construct factories in new version. The game map become twise bigger;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        categories.put(1, category1);
        categories.put(2, category2);
        dataRegistry.registerCategories(categories);

        Assert.assertNull("Should return null", dataRegistry.getProjectList(5));
        Assert.assertEquals("Should return category", category1, dataRegistry.getProjectList(1));
    }



    @Test(expected=IndexOutOfBoundsException.class)
    public void whenGetProject() throws Exception {

        DataRegistry dataRegistry = new DataRegistry();
        Map<Integer, ArrayList<ProjectModel>> categories = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);
        ArrayList<ProjectModel> category1 = new ArrayList<>();
        category1.add(new ProjectModel("Gluconazol -", "Brend new anabolics;", 25000000, 7500000, calendar.getTime(),
                "New MOC politics dictetes new requirements for pharmasy;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1));
        category1.add(new ProjectModel("Eczoskeleton -", "This thing upgrades muscle power;", 4000000, 2500000, calendar.getTime(),
                "Limites of human body was reached, but sport of big achievements  isn`t stopped;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1));
        ArrayList<ProjectModel> category2 = new ArrayList<>();
        category2.add(new ProjectModel("Warriors of eternity -", "New game, clone of 'Game of thrones';", 10000, 1500, calendar.getTime(),
                "Game of thrones was a very good game, but it starts to bore people, so new game is on!!;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        category2.add(new ProjectModel("Robo rally 2 -", "Reincarnation of good old strategy;", 7500, 3000, calendar.getTime(),
                "You will be able to construct factories in new version. The game map become twise bigger;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        categories.put(1, category1);
        categories.put(2, category2);
        dataRegistry.registerCategories(categories);
        //TODO refactor to get rid of return null

      //  Assert.assertEquals("Should return null", NullPointerException, dataRegistry.getProject(new int[]{3, 0}));
   // public void testIndexOutOfBoundsException() {
        dataRegistry.getProject(new int[]{2, 6});
 //   }
      Assert.assertEquals("Should return project", category1.get(0), dataRegistry.getProject(new int[]{1,1}));}}
//

