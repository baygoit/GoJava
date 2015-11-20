package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.context.Console;

public class NameInvestStateTest {

    @Test
    public void testOutputContentState() {
        NameInvestState instance = new NameInvestState();
        instance.outputContentState();
    }

    @Test
    public void testChangeState() {
        Console context = mock(Console.class);
        NameInvestState instance = new NameInvestState();
        instance.changeState(context);
        verify(context).setCurrentState(anyObject());
    }

}
