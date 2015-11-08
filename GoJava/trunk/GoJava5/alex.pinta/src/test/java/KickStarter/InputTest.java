package KickStarter;

import static org.junit.Assert.*;
import KickStarter.*;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 18.07.15
 * Time: 7:41
 * @version: 1.0
 */
public class InputTest {
    @Spy
    Input input = new Input(System.in);
    @Mock
    Input mockInput;

    @Test
    public void testInputChoice() throws Exception {
/*
        mockInput.inputChoice();
        verify(mockInput.inputChoice());
        doReturn("OK").when(mockInput.inputChoice()); //.thenReturn("OK");
        assertEquals("OK", input.inputChoice());
*/
    }
}
