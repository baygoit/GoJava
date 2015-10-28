package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.Output;

import static java.lang.String.format;

public class FaqView extends BaseView {
    private static final String INVITE_MESSAGE = format("Enter your question(%s): ", CHOICE_MESSAGE_SHORT);

    public FaqView(Output output) {
        super(output);
    }

    public void render() {
        writeLine(INVITE_MESSAGE);
    }
}
