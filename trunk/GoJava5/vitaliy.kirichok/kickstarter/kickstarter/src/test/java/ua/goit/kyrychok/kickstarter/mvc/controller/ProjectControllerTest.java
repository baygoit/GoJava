package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProjectControllerTest {

    @Mock
    private ProjectModel model;
    @Mock
    private ProjectView view;
    @Mock
    private Output output;
    @Mock
    private DataProvider dataProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void onUpdateModelRenderMainPage() throws Exception {
        ProjectController controller = new ProjectController(dataProvider, output, model, view);
        List<String> input = new ArrayList<>();
        input.add("-1");
        input.add("1");
        input.add("1");

        controller.onInput(input);

        verify(view, times(1)).render(model);
    }
}