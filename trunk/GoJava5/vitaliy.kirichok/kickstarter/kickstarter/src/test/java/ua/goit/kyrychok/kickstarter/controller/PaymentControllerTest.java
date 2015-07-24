package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.view.PaymentView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PaymentControllerTest {

    @Mock
    private PaymentView view;
    @Mock
    private DataProvider dataProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelThenRenderView() throws Exception {
        PaymentController controller = new PaymentController(dataProvider);
        controller.setView(view);
        controller.setCurrentMode(StandByMode.EXPECTED_USER_NAME);

        controller.showModel();

        verify(view, times(1)).render(StandByMode.EXPECTED_USER_NAME);
    }

}