package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;

public class PreloadingStateTest {

    @Test
    public void testOutputContentState() {
        PreloadingState instance = new PreloadingState();
        instance.outputContentState();
    }

    @Test
    public void testChangeState() {
        Console context = new Console();
        PreloadingState instance = new PreloadingState();
        PreloadingState spy = spy(instance);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);

    }

    @Test
    public void testSelectCurrentData() {
        int inData = State.FILE_DATA;
        PreloadingState instance = new PreloadingState();
        instance.selectCurrentData(inData);
        inData = State.OBJECT_DATA;
        instance.selectCurrentData(inData);
    }

}
