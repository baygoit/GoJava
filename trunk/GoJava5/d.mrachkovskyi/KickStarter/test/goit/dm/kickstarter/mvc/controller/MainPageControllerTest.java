package goit.dm.kickstarter.mvc.controller;

import goit.dm.kickstarter.mvc.model.MainPageModel;
import goit.dm.kickstarter.mvc.view.MainPageView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageControllerTest {

    @Mock
    private MainPageModel model;
    @Mock
    private MainPageView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void onApplicationStartRenderMainPage() throws Exception {
        MainPageController controller = new MainPageController(view, model);

        controller.onApplicationStart();
        verify(view, times(1)).render(model);
    }
}
