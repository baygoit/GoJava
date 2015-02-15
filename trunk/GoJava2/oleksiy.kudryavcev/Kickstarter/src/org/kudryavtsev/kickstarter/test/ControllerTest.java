package org.kudryavtsev.kickstarter.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.kudryavtsev.kickstarter.Controller;
import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.inout.InArrayList;
import org.kudryavtsev.kickstarter.inout.Input;
import org.kudryavtsev.kickstarter.inout.OutArrayList;
import org.kudryavtsev.kickstarter.inout.View;

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
