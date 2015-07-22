package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;

public class FaqView extends BaseView {

    public void render(FaqModel model) {
        writeLine(String.format(model.getInviteMessage(), CHOICE_MESSAGE_SHORT));
    }
}
