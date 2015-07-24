package ua.goit.kyrychok.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.view.PaymentView;

public class PaymentControllerTest {

    @Mock
    private PaymentView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelThenRenderView() throws Exception {
        PaymentController controller = new PaymentController();
        controller.setView(view);
        controller.setCurrentMode(StandByMode.USER);

        controller.takeControl();

        //TODO verify(view, times(1)).render(anyString());
    }

}