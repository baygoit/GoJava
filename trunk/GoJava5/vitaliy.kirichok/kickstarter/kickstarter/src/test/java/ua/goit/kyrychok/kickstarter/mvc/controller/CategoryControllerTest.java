package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;
import ua.goit.kyrychok.kickstarter.mvc.view.CategoryView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CategoryControllerTest {

    @Mock
    private CategoryModel model;
    @Mock
    private CategoryView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderView() throws Exception {
        CategoryController controller = new CategoryController();
        controller.setModel(model);
        controller.setView(view);

        controller.showModel();

        verify(view, times(1)).render(model);
    }

}