package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;
import ua.goit.kyrychok.kickstarter.mvc.view.MainPageView;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainPageControllerTest {

    @Mock
    private MainPageModel model;
    @Mock
    private MainPageView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void onUpdateModelRenderMainPage() throws Exception {
        MainPageController controller = new MainPageController(model, view);
        List<String> input = new ArrayList<>();
        input.add("-1");

        controller.onInput(input);

        verify(view, times(1)).render(model);
    }
}