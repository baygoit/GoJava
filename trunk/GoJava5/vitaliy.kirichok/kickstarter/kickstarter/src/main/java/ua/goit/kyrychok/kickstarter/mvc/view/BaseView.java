package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.Output;

import static ua.goit.kyrychok.kickstarter.mvc.controller.BaseController.EXIT_CODE;

public abstract class BaseView {
    public static final String CHOICE_MESSAGE = String.format("Your choice(%s - exit): ", EXIT_CODE);

    private Output output;

    public void setOutput(Output output) {
        this.output = output;
    }

    public Output getOutput() {
        return output;
    }
}
