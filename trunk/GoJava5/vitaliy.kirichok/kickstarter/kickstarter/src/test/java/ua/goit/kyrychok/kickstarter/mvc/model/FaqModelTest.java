package ua.goit.kyrychok.kickstarter.mvc.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class FaqModelTest {

    @Test
    public void whenGetInviteMessageThenReturnNotEmptyMessage() throws Exception {
        FaqModel model = new FaqModel();

        String result = model.getInviteMessage();

        assertNotNull("Invite message can't be null", result);
        assertTrue("Invite message can't be empty", result.length() > 0);
    }
}