package ua.com.goit.gojava7.salivon.state;

import junit.framework.AssertionFailedError;
import org.junit.Test;
import ua.com.goit.gojava7.salivon.context.Console;
import static org.mockito.Mockito.*;

public class WelcomeStateTest {

    @Test
    public void testOutputContentState() {
        State.setCurrentData(State.FILE_DATA);
        WelcomeState instance = new WelcomeState();
        instance.outputContentState();

    }

    @Test
    public void testChangeState() {
        State.setCurrentData(State.FILE_DATA);
        Console context = new Console();
        WelcomeState instance = new WelcomeState();
        WelcomeState spy = spy(instance);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);

    }

    @Test(expected = AssertionFailedError.class)
    public void testChangeStateQuit() {
        State.setCurrentData(State.FILE_DATA);
        Console context = new Console();
        WelcomeState instance = new WelcomeState();
        WelcomeState spy = spy(instance);
        when(spy.getInData()).thenReturn("q");
        doThrow(new AssertionFailedError()).when(spy).changeState(context);
        spy.changeState(context);

    }

}
