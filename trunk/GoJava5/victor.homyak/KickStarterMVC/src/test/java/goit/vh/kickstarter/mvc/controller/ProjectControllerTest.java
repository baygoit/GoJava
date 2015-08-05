package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.ProjectView;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Viktor on 26.07.2015.
 */
public class ProjectControllerTest {
     @Mock
    ProjectView projectView;

    @Mock
    ProjectModel projectModel;

    @Mock
    private LocationManager locationManager;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }



    @Test()
         public void shouldDispatchToProjectView() throws Exception {
        int[] path = new int[]{2, 1};

        ProjectController projectController = new ProjectController(projectView, projectModel);
        projectController.setLocationManager(locationManager);

        when(projectView.getInput()).thenReturn("1");
        locationManager.setPath(path);
        projectController.start(path);

        verify(projectModel,times(2)).refreshModel(path);
        verify(projectView).render(projectModel);
        verify(projectView).readInProjectUserInput();

    }

    @Test()
    public void shouldDispatchToListOfProjects() throws Exception {
        int[] path = new int[]{2, 1};

        ProjectController projectController = new ProjectController(projectView, projectModel);
        projectController.setLocationManager(locationManager);
      //  when(projectModel.refreshModel(path)).thenReturn("1");
        when(projectView.getInput()).thenReturn("1");
        locationManager.setPath(path);
        projectController.start(path);

        verify(projectModel,times(2)).refreshModel(path);
        verify(projectView).render(projectModel);
        verify(projectView).readInProjectUserInput();
        verify(locationManager).dispatch();

    }

}