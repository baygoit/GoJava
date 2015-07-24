package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.StandByMode;

import static java.lang.String.format;

public class PaymentView extends BaseView {

    public PaymentView(Output output) {
        super(output);
    }

    public void render(StandByMode mode) {
        switch (mode) {
            case EXPECTED_USER_NAME:
                writeLine(format("Enter user name(%s): ", CHOICE_MESSAGE_SHORT));
                break;
            case EXPECTED_CARD_NO:
                writeLine(format("Enter card number(%s): ", CHOICE_MESSAGE_SHORT));
                break;
            case EXPECTED_AMOUNT:
                writeLine(format("Enter pledge amount(%s): ", CHOICE_MESSAGE_SHORT));
                break;
        }
    }
}
