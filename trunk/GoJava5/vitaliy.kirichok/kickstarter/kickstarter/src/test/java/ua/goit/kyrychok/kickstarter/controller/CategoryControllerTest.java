package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.view.CategoryView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CategoryControllerTest {

    @Mock
    private Category model;
    @Mock
    private CategoryView view;
    @Mock
    private DataProvider dataProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderView() throws Exception {
        CategoryController controller = new CategoryController(dataProvider);
        controller.setView(view);
        controller.setModel(model);

        controller.showModel();

        verify(view, times(1)).render(model);
    }

}