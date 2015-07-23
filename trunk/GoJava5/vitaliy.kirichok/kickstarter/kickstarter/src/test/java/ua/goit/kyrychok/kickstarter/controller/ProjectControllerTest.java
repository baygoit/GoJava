package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.view.ProjectView;

public class ProjectControllerTest {

    //TODO @Mock
    //TODO private ProjectModel model;
    @Mock
    private ProjectView view;
    @Mock
    private AbstractController abstractController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderMainPage() throws Exception {
        ProjectController controller = new ProjectController();
        controller.setParentController(abstractController);
        controller.setView(view);
        //TODO  controller.setModel(model);

        controller.showModel();

        //TODO  verify(view, times(1)).render(model);
    }
}