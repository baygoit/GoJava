package ua.goit.kyrychok.kickstarter.view;

import org.junit.Test;
import ua.goit.kyrychok.kickstarter.ConsoleOutput4Test;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.junit.Assert.assertTrue;

public class FaqViewTest {
    private ConsoleOutput4Test output = new ConsoleOutput4Test();

    @Test
    public void whenRenderThenPrintInviteMessage() throws Exception {

        FaqView faqView = new FaqView(output);

        faqView.render();

        assertTrue("Invite message must be showed", output.getResult().size() == 1);
        assertTrue("Invite message can't be empty", isNotBlank(output.getResult().get(0)));
    }
}