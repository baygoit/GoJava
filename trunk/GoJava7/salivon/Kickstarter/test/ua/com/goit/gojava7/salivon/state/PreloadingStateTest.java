package ua.com.goit.gojava7.salivon.state;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;

public class PreloadingStateTest {

    PreloadingState instance;

    @Before
    public void setUp() {
        instance = new PreloadingState();
    }

    @Test
    public void testOutputContentState() {
        instance.outputContentState();
    }

    @Test
    public void testValidate() {
        assertEquals(false, instance.validate(""));
        assertEquals(true, instance.validate("3"));
        assertEquals(true, instance.validate("1"));
        assertEquals(true, instance.validate("2"));
        assertEquals(false, instance.validate("4"));

    }

    @Test
    public void testChangeState() {
        Console context = new Console();
        PreloadingState spy = spy(instance);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);

    }

    @Test
    public void testSelectCurrentData() {
        int inData = 1;
        instance.selectCurrentData(inData);
        inData = 2;
        instance.selectCurrentData(inData);
        inData = 3;
        instance.selectCurrentData(inData);
    }

}
