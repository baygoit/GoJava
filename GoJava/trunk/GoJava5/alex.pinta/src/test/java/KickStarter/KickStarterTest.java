package KickStarter;

import KickStarter.controller.Dispatcher;
import KickStarter.dao.ManualInput;
import KickStarter.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 18.07.15
 * Time: 8:10
 * @version: 1.0
 */
public class KickStarterTest {
    @Mock
    Dispatcher dispatcher;
    @Before
    public void init() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
//    @Mock
//    Input input;
//    @Test
//    public void testRun() throws Exception {
//        KickStarter kickStarter = new KickStarter(System.in, System.out);
//        kickStarter.run();
//        verify(dispatcher).startApplication(isA(ManualInput.class));
//    }
}
