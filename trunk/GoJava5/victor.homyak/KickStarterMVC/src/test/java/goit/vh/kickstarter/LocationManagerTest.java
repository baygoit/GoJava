package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.MainPageController;
import goit.vh.kickstarter.mvc.controller.ProjectController;
import jdk.nashorn.internal.runtime.ArgumentSetter;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
/**
 * Created by viktor on 23.07.2015.
 */
public class LocationManagerTest  {

    @Mock
    private MainPageController mainPageController;

    @Mock
    private CategoryController categoryController;

    @Mock
    private ProjectController projectController;



 //   private LocationManager locationManager;
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
     //   locationManager = mock(LocationManager.class);
    }

   @Test
   public void whenDispatchToMainPageController(){

       LocationManager locationManager = new LocationManager(mainPageController,categoryController,projectController);

       locationManager.dispatch();

//       verify(mainPageController,times(1)).start(new int[]{0, 0});
//
   }
//    @Test
//    public void whenDispatchToCategoryController(){
//
//        LocationManager locationManager = new LocationManager(mainPageController,categoryController,projectController);
//
//        locationManager.dispatch();
//
//        verify(mainPageController,times(1)).start(new int[]{2, 0});
//        verify(categoryController,times(1)).start(new int[]{2, 0});
//
//    }
//
//    @Test
//    public void whenDispatchToProjestController(){
//
//        LocationManager locationManager = new LocationManager(mainPageController,categoryController,projectController);
//
//        locationManager.dispatch();
//
//
//        verify(projectController, times(1)).start(new int[]{3, 2});
//
//    }

}