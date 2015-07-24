package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Reward;
import ua.goit.kyrychok.kickstarter.view.DonatePageView;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DonatePageControllerTest {

    @Mock
    private DonatePageView view;
    @Mock
    private DataProvider dataProvider;
    @Mock
    private List<Reward> model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenShowModelThenRenderView() throws Exception {
        DonatePageController controller = new DonatePageController(dataProvider);
        controller.setView(view);
        controller.setModel(model);

        controller.showModel();

        verify(view, times(1)).render(model);
    }
}