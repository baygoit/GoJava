package ua.goit.kyrychok.kickstarter.controller;

import org.apache.commons.validator.routines.FloatValidator;
import ua.goit.kyrychok.kickstarter.StandByMode;

public class PaymentController extends AbstractPaymentController {

    @Override
    protected void changeMode() {
        switch (currentMode) {
            case USER:
                currentMode = StandByMode.CARD;
                break;
            case CARD:
                currentMode = StandByMode.AMOUNT;
                break;
            case AMOUNT:
                currentMode = StandByMode.USER;
                break;
            default:
                throw new IndexOutOfBoundsException("Unexpected input value");
        }
    }

    private int convertAmount(String input) {
        return (int) (FloatValidator.getInstance().validate(input) * 100);
    }

    @Override
    protected void updateModel(String input) {
        if (currentMode == StandByMode.AMOUNT) {
            dataProvider.incProjectBalance(projectId, convertAmount(input));
        }
    }

    @Override
    protected BaseController returnNextController() {
        switch (currentMode) {
            case AMOUNT:
                return getParentController();
            case USER:
            case CARD:
                return this;
            default:
                throw new IndexOutOfBoundsException("Unexpected input value");
        }
    }
}
