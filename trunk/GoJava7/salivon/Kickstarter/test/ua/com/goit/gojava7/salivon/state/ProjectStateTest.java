package ua.com.goit.gojava7.salivon.state;

import junit.framework.AssertionFailedError;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;

public class ProjectStateTest {

    @Test
    public void testOutputContentState() {
        State.setCurrentData(State.FILE_DATA);
        State.setIndexCategory(1);
        State.setIndexProject(3);
        ProjectState instance = new ProjectState();
        instance.outputContentState();
    }

    @Test
    public void testChangeState() {
        State.setCurrentData(State.FILE_DATA);
        Console context = new Console();
        ProjectState instance = new ProjectState();
        ProjectState spy = spy(instance);
        when(spy.getInData()).thenReturn("0");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("2");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("3");
        spy.changeState(context);
    }

    @Test(expected = AssertionFailedError.class)
    public void testChangeStateQuit() {
        State.setCurrentData(State.FILE_DATA);
        Console context = new Console();
        ProjectState instance = new ProjectState();
        ProjectState spy = spy(instance);
        when(spy.getInData()).thenReturn("q");
        doThrow(new AssertionFailedError()).when(spy).changeState(context);
        spy.changeState(context);

    }

}
