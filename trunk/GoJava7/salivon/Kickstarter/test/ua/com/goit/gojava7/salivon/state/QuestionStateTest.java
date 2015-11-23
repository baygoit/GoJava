package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;

public class QuestionStateTest {

    @Test
    public void testOutputContentState() {
        State.setCurrentData(State.FILE_DATA);
        QuestionState instance = new QuestionState();
        instance.outputContentState();

    }

    @Test
    public void testChangeState() {
        State.setCurrentData(State.FILE_DATA);
        Console context = new Console();
        QuestionState instance = new QuestionState();
        QuestionState spy = spy(instance);
        State.setIndexProject(5);
        when(spy.getInData()).thenReturn("Hello????");
        spy.changeState(context);
    }

}
