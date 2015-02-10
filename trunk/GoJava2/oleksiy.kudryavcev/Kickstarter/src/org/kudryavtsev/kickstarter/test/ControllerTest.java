package org.kudryavtsev.kickstarter.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kudryavtsev.kickstarter.Controller;
import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.inout.InArrayList;
import org.kudryavtsev.kickstarter.inout.Input;
import org.kudryavtsev.kickstarter.inout.OutArrayList;
import org.kudryavtsev.kickstarter.inout.View;

public class ControllerTest {
    Model model = new Model();
    View view = new View(new OutArrayList());
    Input input = new Input(new InArrayList());
    Controller controller = new Controller(model, view, input);

    @Test
    public void testControllerStart() {
        controller.start();
    }

}
