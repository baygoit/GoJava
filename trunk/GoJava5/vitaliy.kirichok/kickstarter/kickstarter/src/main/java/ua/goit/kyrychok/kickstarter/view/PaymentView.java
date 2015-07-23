package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.StandByMode;

import static java.lang.String.format;

public class PaymentView extends BaseView {

    public void render(StandByMode mode) {
        switch (mode) {
            case USER:
                writeLine(format("Enter user name(%s): ", CHOICE_MESSAGE_SHORT));
                break;
            case CARD:
                writeLine(format("Enter card number(%s): ", CHOICE_MESSAGE_SHORT));
                break;
            case AMOUNT:
                writeLine(format("Enter pledge amount(%s): ", CHOICE_MESSAGE_SHORT));
                break;
        }
    }
}
