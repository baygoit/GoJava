package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.kudryavtsev.kickstarter.Controller;
import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.in.InArrayList;
import org.kudryavtsev.kickstarter.in.Input;
import org.kudryavtsev.kickstarter.out.OutArrayList;
import org.kudryavtsev.kickstarter.out.View;

public class ControllerTest {
    Controller controller = new Controller(new Model(), new View(new OutArrayList()), new Input(
            new InArrayList()));
    Controller mockedController = mock(Controller.class);

    @Test
    public void testControllerStart() {
        mockedController.start();
        verify(mockedController).start();
    }
}
