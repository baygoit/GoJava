package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.view.FaqView;

public class FaqControllerTest {

    //TODO @Mock
    //TODO private FaqModel model;
    @Mock
    private FaqView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderFaqPage() throws Exception {
        FaqController controller = new FaqController();
        controller.setView(view);
        //TODO controller.setModel(model);

        controller.showModel();

        //TODO verify(view, times(1)).render(model);
    }

}