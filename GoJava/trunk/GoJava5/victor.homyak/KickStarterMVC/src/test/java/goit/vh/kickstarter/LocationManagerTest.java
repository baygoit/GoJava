package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.MainPageController;
import goit.vh.kickstarter.mvc.controller.ProjectController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by viktor on 23.07.2015.
 */
public class LocationManagerTest {

    @Mock
    private MainPageController mainPageController;

    @Mock
    private CategoryController categoryController;

    @Mock
    private ProjectController projectController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldDispatchToMainPageController() {

        LocationManager locationManager = new LocationManager(mainPageController, categoryController, projectController);
        locationManager.dispatch();

        verify(mainPageController, times(1)).start(new int[]{0, 0});

    }

    @Test
    public void shouldDispatchToCategoryController() {

        LocationManager locationManager = new LocationManager(mainPageController, categoryController, projectController);
        locationManager.setPath(new int[]{2, 0});
        locationManager.dispatch();

        verify(categoryController, times(1)).start(new int[]{2, 0});

    }

    @Test
    public void shouldDispatchToProjestController() {

        LocationManager locationManager = new LocationManager(mainPageController, categoryController, projectController);
        locationManager.setPath(new int[]{3, 1});
        locationManager.dispatch();

        verify(projectController, times(1)).start(new int[]{3, 1});

    }

}