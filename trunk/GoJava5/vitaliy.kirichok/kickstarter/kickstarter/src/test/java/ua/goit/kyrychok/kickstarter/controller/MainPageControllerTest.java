package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.view.MainPageView;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainPageControllerTest {

    @Mock
    private DataProvider dataProvider;
    @Mock
    private MainPageView view;
    @Mock
    private List<Category> model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderMainPage() throws Exception {
        MainPageController controller = new MainPageController(dataProvider);
        controller.setView(view);
        controller.setModel(model);

        controller.showModel();

        verify(view, times(1)).render(model, null);
    }
}