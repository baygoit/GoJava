package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProjectControllerTest {

    @Mock
    private ProjectModel model;
    @Mock
    private ProjectView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void onUpdateModelRenderMainPage() throws Exception {
        ProjectController controller = new ProjectController(model, view);

        controller.update(anyInt(), anyInt());

        verify(view, times(1)).render(model);
    }
}