package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.view.FaqView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FaqControllerTest {

    @Mock
    private FaqView view;
    @Mock
    private DataProvider dataProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderFaqPage() throws Exception {
        FaqController controller = new FaqController(dataProvider);
        controller.setView(view);

        controller.showModel();

        verify(view, times(1)).render();
    }

}