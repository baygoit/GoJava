package ua.com.goit.gojava7.salivon.state;

import junit.framework.AssertionFailedError;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class CategoryStateTest {

    @Test
    public void testOutputContentStateForFile() {
        State.setCurrentDataType(DataType.FILE);
        State.setIdCategory(1);
        CategoryState instance = new CategoryState();
        instance.outputContentState();
    }

    @Test
    public void testChangeStateForFile() {
        State.setCurrentDataType(DataType.FILE);
        State.setIdCategory(1);
        Console context = new Console();
        CategoryState instance = new CategoryState();
        CategoryState spy = spy(instance);
        when(spy.getInData()).thenReturn("0");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);
    }

    @Test(expected = AssertionFailedError.class)
    public void testChangeStateQuitForFile() {
        Console context = new Console();
        State.setCurrentDataType(DataType.FILE);
        CategoryState instance = new CategoryState();
        CategoryState spy = spy(instance);
        when(spy.getInData()).thenReturn("q");
        doThrow(new AssertionFailedError()).when(spy).changeState(context);
        spy.changeState(context);

    }

    @Test
    public void testOutputContentStateForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        State.setIdCategory(1);
        CategoryState instance = new CategoryState();
        instance.outputContentState();
    }

    @Test
    public void testChangeStateForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        State.setIdCategory(1);
        Console context = new Console();
        CategoryState instance = new CategoryState();
        CategoryState spy = spy(instance);
        when(spy.getInData()).thenReturn("0");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);
    }

    @Test(expected = AssertionFailedError.class)
    public void testChangeStateQuitForMemory() {
        Console context = new Console();
        State.setCurrentDataType(DataType.MEMORY);
        CategoryState instance = new CategoryState();
        CategoryState spy = spy(instance);
        when(spy.getInData()).thenReturn("q");
        doThrow(new AssertionFailedError()).when(spy).changeState(context);
        spy.changeState(context);

    }

}
