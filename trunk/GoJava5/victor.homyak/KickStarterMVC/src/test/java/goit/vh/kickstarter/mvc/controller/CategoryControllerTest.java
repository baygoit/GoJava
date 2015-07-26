package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.CategoryView;
import goit.vh.kickstarter.mvc.view.ProjectView;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
/**
 * Created by Viktor on 25.07.2015.
 */
public class CategoryControllerTest  {

    @Mock
    private ProjectModel projectModel;


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
    private Output output ;

   private CategoryController categoryController;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryController = mock(CategoryController.class);
    }


    @Test()
    public void whenDispatchToMain() throws Exception {
        int[] path = new int[]{0, 0};

        //CategoryController categoryController = new CategoryController(view, projectView, model, projectModel);
             categoryController.start(path);

        verify(model).refreshModel(path[0]);
        locationManager.setPath(path);
        verify(locationManager).dispatch();

    }


}