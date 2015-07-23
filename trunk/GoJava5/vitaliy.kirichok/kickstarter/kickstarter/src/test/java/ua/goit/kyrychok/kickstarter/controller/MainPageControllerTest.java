package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.view.MainPageView;

public class MainPageControllerTest {

    //TODO @Mock
    //TODO private MainPageModel model;
    @Mock
    private MainPageView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderMainPage() throws Exception {
        MainPageController controller = new MainPageController();
        controller.setView(view);
        //TODO controller.setModel(model);

        controller.showModel();

        //TODO verify(view, times(1)).render(model);
    }
}