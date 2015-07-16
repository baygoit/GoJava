package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;

public class FaqView extends BaseView {

    public void render(FaqModel model) {
        getOutput().writeLine(model.getInviteMessage());
        getOutput().writeLine(CHOICE_MESSAGE);
    }
}
