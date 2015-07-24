package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.view.ProjectView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProjectControllerTest {

    @Mock
    private Project model;
    @Mock
    private ProjectView view;
    @Mock
    private DataProvider dataProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderView() throws Exception {
        ProjectController controller = new ProjectController(dataProvider);
        controller.setView(view);
        controller.setModel(model);

        controller.showModel();

        verify(view, times(1)).render(model);
    }
}