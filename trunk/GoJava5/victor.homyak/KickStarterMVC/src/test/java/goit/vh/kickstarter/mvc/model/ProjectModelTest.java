package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.controller.CategoryController;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
/**
 * Created by Viktor on 26.07.2015.
 */
public class ProjectModelTest  {

    @Mock
    private DataRegistry dataRegistry;

    @Mock
    private ArrayList<ProjectModel> listOfProjectses;

//    @Mock
//    private ProjectModel projectModel;



    @Before

    public  void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test()
    public void whenRefreshModelShouldReturn0() throws Exception {
        int[] path = new int[]{30,9};
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);

        ProjectModel projectModel =new ProjectModel("Gluconazol -", "Brend new anabolics;", 25000000, 7500000, calendar.getTime(),
                "New MOC politics dictetes new requirements for pharmasy;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1);
          // DataRegistry dataRegistry = new DataRegistry();
         projectModel.setDataRegistry(dataRegistry);
        Assert.assertEquals("Should return null", null, dataRegistry.getProject(path));
        projectModel.refreshModel(path);
    }

    @Test()
    public void whenRefreshModelShouldReturn1() throws Exception {
        int[] path = new int[]{1,1};
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);

        ProjectModel projectModel =new ProjectModel("Gluconazol -", "Brend new anabolics;", 25000000, 7500000, calendar.getTime(),
                "New MOC politics dictetes new requirements for pharmasy;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1);
        // DataRegistry dataRegistry = new DataRegistry();
        projectModel.setDataRegistry(dataRegistry);
       when(dataRegistry.getProject(path)).thenReturn(projectModel);
      //  Assert.assertEquals("Should return 1", 1, projectModel.refreshModel(path));
        projectModel.refreshModel(path);
    }

//    @Test()
//         public void whenRefreshModelListShouldReturn0()  {
//        ProjectModel projectModel = new ProjectModel();
//     //   DataRegistry dataRegistry = new DataRegistry();
//        ArrayList<ProjectModel> arrayList = new ArrayList<>();
//        Map<Integer,ArrayList<ProjectModel>> mapOfSize2 = new HashMap<>();
//        mapOfSize2.put(1, arrayList);
//
//        dataRegistry.registerCategories(mapOfSize2);
//        //when(dataRegistry.getCategories()).thenReturn(mapOfSize2);
//        // DataRegistry dataRegistry = new DataRegistry();
//       projectModel.setDataRegistry(dataRegistry);
//        when(dataRegistry.getCategories()).thenReturn(mapOfSize2);
//        when(dataRegistry.getProjectList(50)).thenReturn(arrayList);
//        projectModel.refreshListModel(50);
//        Assert.assertNull("Should return null",dataRegistry.getProjectList(50));
//
//    }

   @Test

   public void whenRefreshListModelReturnNull()throws Exception{

   }

    @Test()
    public void whenRefreshModelListShouldReturn1() throws Exception {
        ProjectModel projectModel = new ProjectModel();
        Map<Integer,ArrayList<ProjectModel>> mapOfSize2 = new HashMap<>();
        mapOfSize2.put(1, new ArrayList());
        mapOfSize2.put(1, new ArrayList());

        //when(dataRegistry.getCategories()).thenReturn(mapOfSize2);
        // DataRegistry dataRegistry = new DataRegistry();
        projectModel.setDataRegistry(dataRegistry);
        projectModel.refreshListModel(1);
        Assert.assertNotNull("Should return null", dataRegistry.getProjectList(1));

    }

}