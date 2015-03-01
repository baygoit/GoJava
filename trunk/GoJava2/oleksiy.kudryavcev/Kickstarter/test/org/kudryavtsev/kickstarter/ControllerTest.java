package org.kudryavtsev.kickstarter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.in.In;
import org.kudryavtsev.kickstarter.in.InArrayList;
import org.kudryavtsev.kickstarter.out.OutArrayList;
import org.kudryavtsev.kickstarter.out.View;

public class ControllerTest {

    @Test
    public void testControllerStart() {
        // given
        OutArrayList out = new OutArrayList();
        In in = new InArrayList(1, 1, 0, 0, 0);

        Controller controller = new Controller(new Model(), new View(out), in);

        // when
        controller.start();

        // then
        assertEquals(
                "[Лучший способ предвидеть будущее - это самим создать его., (1) Sport - Sport projects, (2) Technology - Technology projects, (3) Science - Science projects, You choice (0 - exit):, (1) FutureForward; FutureForward is an innovative training project; funded: 4; pledged: 200; days to go: 45, (2) U23; Support Team Canada U23 in their quest for Gold!; funded: 5500; pledged: 5000; days to go: 5, You choice (0 - exit):, (1) Sport - Sport projects, (2) Technology - Technology projects, (3) Science - Science projects, You choice (0 - exit):]",
                out.getAll().toString());
    }

    @Test
    public void testControllerStart2() {
        // given
        OutArrayList out = new OutArrayList();
        In in = new InArrayList(1, 1, 0, 2, 0, 0, 2, 1, 0, 2, 0, 0, 3, 1, 0, 2, 0, 0, 0);

        Controller controller = new Controller(new Model(), new View(out), in);

        // when
        controller.start();

        // then
        assertTrue(out.getAll().toString().contains(""));
    }

    @Test
    public void testControllerStart3() {
        // given
        OutArrayList out = new OutArrayList();
        In in = new InArrayList(1, 2, 5, 0, 0);

        Controller controller = new Controller(new Model(), new View(out), in);

        // when
        controller.start();

        // then
        assertTrue(out.getAll().toString().contains(""));
    }
}
