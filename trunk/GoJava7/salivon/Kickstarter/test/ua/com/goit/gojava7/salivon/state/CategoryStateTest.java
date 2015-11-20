package ua.com.goit.gojava7.salivon.state;

import junit.framework.AssertionFailedError;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;

public class CategoryStateTest {

    @Test
    public void testOutputContentState() {
        State.setCurrentData(State.FILE_DATA);
        State.setIndexCategory(1);
        CategoryState instance = new CategoryState();
        instance.outputContentState();
    }

    @Test
    public void testChangeState() {
        State.setCurrentData(State.FILE_DATA);
        State.setIndexCategory(1);
        Console context = new Console();
        CategoryState instance = new CategoryState();
        CategoryState spy = spy(instance);
        when(spy.getInData()).thenReturn("0");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);
    }

    @Test(expected = AssertionFailedError.class)
    public void testChangeStateQuit() {
        Console context = new Console();
        State.setCurrentData(State.FILE_DATA);
        CategoryState instance = new CategoryState();
        CategoryState spy = spy(instance);
        when(spy.getInData()).thenReturn("q");
        doThrow(new AssertionFailedError()).when(spy).changeState(context);
        spy.changeState(context);

    }

}
