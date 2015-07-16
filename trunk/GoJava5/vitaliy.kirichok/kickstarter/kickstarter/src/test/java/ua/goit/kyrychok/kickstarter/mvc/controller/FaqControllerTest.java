package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;
import ua.goit.kyrychok.kickstarter.mvc.view.FaqView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FaqControllerTest {

    @Mock
    private FaqModel model;
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
        controller.setModel(model);

        controller.showModel();

        verify(view, times(1)).render(model);
    }

}