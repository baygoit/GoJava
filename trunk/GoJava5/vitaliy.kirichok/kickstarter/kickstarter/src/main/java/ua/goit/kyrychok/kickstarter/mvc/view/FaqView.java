package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;

import static ua.goit.kyrychok.kickstarter.Utils.CHOICE_MESSAGE;

public class FaqView {
    private Output output;

    public FaqView(Output output) {
        this.output = output;
    }

    public void render(FaqModel model) {
        output.writeLine(model.getInviteMessage());
        output.writeLine(CHOICE_MESSAGE);
    }
}
