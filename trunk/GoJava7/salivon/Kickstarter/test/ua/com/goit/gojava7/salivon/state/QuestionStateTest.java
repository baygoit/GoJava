package ua.com.goit.gojava7.salivon.state;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class QuestionStateTest {

    @Test
    public void testOutputContentStateForFile() {
        State.setCurrentDataType(DataType.FILE);
        QuestionState instance = new QuestionState();
        instance.outputContentState();

    }

    @Test
    public void testValidateForFile() {
        State.setCurrentDataType(DataType.FILE);
        QuestionState instance = new QuestionState();
        assertEquals(true, instance.validate(""));
    }

    @Test
    public void testValidateForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        QuestionState instance = new QuestionState();
        assertEquals(true, instance.validate(""));
    }

    @Test
    public void testChangeStateForFile() {
        State.setCurrentDataType(DataType.FILE);
        Console context = new Console();
        QuestionState instance = new QuestionState();
        QuestionState spy = spy(instance);
        State.setIdProject(5);
        when(spy.getInData()).thenReturn("Hello????");
        spy.changeState(context);
    }

    @Test
    public void testOutputContentStateForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        QuestionState instance = new QuestionState();
        instance.outputContentState();

    }

    @Test
    public void testChangeStateForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        Console context = new Console();
        QuestionState instance = new QuestionState();
        QuestionState spy = spy(instance);
        State.setIdProject(5);
        when(spy.getInData()).thenReturn("Hello????");
        spy.changeState(context);
    }

}
