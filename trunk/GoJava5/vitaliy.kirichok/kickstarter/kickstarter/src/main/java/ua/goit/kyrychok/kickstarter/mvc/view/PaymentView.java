package ua.goit.kyrychok.kickstarter.mvc.view;

public class PaymentView extends BaseView {

    public void render(String inviteMessage) {
        writeLine(String.format(inviteMessage, CHOICE_MESSAGE_SHORT));
    }
}
