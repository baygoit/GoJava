package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.mvc.model.DonatePageModel;
import ua.goit.kyrychok.kickstarter.mvc.view.DonatePageView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DonatePageControllerTest {

    @Mock
    private DonatePageView view;
    @Mock
    private DonatePageModel model;

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

        verify(view, times(1)).render(model);
    }
}