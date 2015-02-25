package test;

import org.junit.Test;
import org.kudryavtsev.kickstarter.MVC;
import static org.mockito.Mockito.*;

public class MVCTest {

    @Test
    public void testMVC() {
        MVC mvc = new MVC();
        MVC mockedMVC = mock(MVC.class);
        verify(mockedMVC);
    }
}
