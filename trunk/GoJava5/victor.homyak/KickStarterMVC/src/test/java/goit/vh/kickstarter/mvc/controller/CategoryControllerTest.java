package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.CategoryView;
import goit.vh.kickstarter.mvc.view.ProjectView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by Viktor on 25.07.2015.
 */
public class CategoryControllerTest {

    @Mock
    private ProjectModel projectModel;

    @Mock
    private LocationManager locationManager;

    @Mock
    private CategoryView view;

    @Mock
    private ProjectView projectView;

    @Mock
    private CategoryModel model;

    @Mock
    private Input input;

    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test()
    public void shouldDispatchToMain() throws Exception {
        int[] path = new int[]{0, 0};

        CategoryController categoryController = new CategoryController(view, projectView, model, projectModel);
        categoryController.setLocationManager(locationManager);
        locationManager.setPath(path);

        categoryController.start(path);

        verify(model).refreshModel(path[0]);
        verify(locationManager).dispatch();

    }

    @Test()
    public void shouldDispatchListOfProjects() throws Exception {
        int[] path = new int[]{2, 0};

        CategoryController categoryController = new CategoryController(view, projectView, model, projectModel);
        categoryController.setLocationManager(locationManager);
        locationManager.setPath(path);
        when(projectView.getInput()).thenReturn("1");
        categoryController.start(path);

        verify(model,times(2)).refreshModel(path[0]);
        verify(locationManager, times(4)).dispatch();

    }


}