package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.view.DonatePageView;

public class DonatePageControllerTest {

    @Mock
    private DonatePageView view;
    //TODO @Mock
    //TODO private DonatePageModel model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    @Test
    public void whenShowModelThenRenderView() throws Exception {
        DonatePageController controller = new DonatePageController();
        controller.setView(view);

        controller.showModel();

        //TODO verify(view, times(1)).render(model);
    }
}