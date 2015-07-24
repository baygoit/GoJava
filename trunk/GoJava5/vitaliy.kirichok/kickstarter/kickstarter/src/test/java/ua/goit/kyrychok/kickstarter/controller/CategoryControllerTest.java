package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.view.CategoryView;

public class CategoryControllerTest {

    //TODO @Mock
    //TODO private CategoryModel model;
    @Mock
    private CategoryView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderView() throws Exception {
        CategoryController controller = new CategoryController();
        //TODO controller.setModel(model);
        controller.setView(view);

        controller.takeControl();

        //TODO verify(view, times(1)).render(model);
    }

}