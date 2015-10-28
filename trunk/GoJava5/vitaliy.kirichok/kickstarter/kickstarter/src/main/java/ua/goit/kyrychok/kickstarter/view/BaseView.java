package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.Output;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static ua.goit.kyrychok.kickstarter.controller.AbstractController.EXIT_CODE;

public abstract class BaseView {
    public static final String CHOICE_MESSAGE_SHORT = String.format("%s - exit", EXIT_CODE);
    public static final String CHOICE_MESSAGE = String.format("Your choice(%s): ", CHOICE_MESSAGE_SHORT);

    private Output output;

    public BaseView(Output output) {
        this.output = output;
    }

    protected void writeLine(String line) {
        if (isNotBlank(line)) {
            output.writeLine(line);
        }
    }

    protected void writeLineWithParam(String line, String param) {
        if (isNotBlank(param)) {
            writeLine(String.format(line, param));
        }
    }

    public void writeError(String errorMessage) {
        writeLineWithParam("ERROR: %s", errorMessage);
    }
}
