package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.view.MainPageView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

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

//    @Mock
//    private MainPageController controller;

    @Mock
    private MainPageView view;

    @Mock
    private LocationManager locationManager;

    @Mock
    private Input input;

    private MainPageController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //   controller = mock(MainPageController.class);
    }

    //TODO How to path through this?????
    @Test()
    public void onApplicationStartRenderMainPage() throws Exception {
        MainPageController controller = new MainPageController(view, model);
        int[] path = new int[]{1, 0};

         verify(controller,times(1)).start(path);
//         verify(view, times(1)).render(model);
//        verify(locationManager,times(1)).dispatch();
    }
}
