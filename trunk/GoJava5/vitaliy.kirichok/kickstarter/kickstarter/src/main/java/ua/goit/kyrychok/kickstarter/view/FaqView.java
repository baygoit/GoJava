package ua.goit.kyrychok.kickstarter.view;

import static java.lang.String.format;

public class FaqView extends BaseView {
    private static final String INVITE_MESSAGE = format("Enter your question(%s): ", CHOICE_MESSAGE_SHORT);

    public void render() {
        writeLine(INVITE_MESSAGE);
    }
}
