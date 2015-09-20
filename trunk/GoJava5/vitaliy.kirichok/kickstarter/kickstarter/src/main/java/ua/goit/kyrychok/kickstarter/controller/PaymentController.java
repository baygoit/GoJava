package ua.goit.kyrychok.kickstarter.controller;

import org.apache.commons.validator.routines.FloatValidator;
import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;

public class PaymentController extends AbstractPaymentController {

    public PaymentController(ProjectDao projectDao) {
        super(projectDao);
    }

    @Override
    protected void changeMode() {
        switch (currentMode) {
            case EXPECTED_USER_NAME:
                currentMode = StandByMode.EXPECTED_CARD_NO;
                break;
            case EXPECTED_CARD_NO:
                currentMode = StandByMode.EXPECTED_AMOUNT;
                break;
            case EXPECTED_AMOUNT:
                currentMode = StandByMode.EXPECTED_USER_NAME;
                break;
        }
    }

    private int convertAmount(String input) {
        return (int) (FloatValidator.getInstance().validate(input) * 100);
    }

    @Override
    protected void addPayment(String input) {
        if (currentMode == StandByMode.EXPECTED_AMOUNT) {
            incProjectBalance(projectId, convertAmount(input));
        }
    }

    @Override
    protected AbstractController returnNextController() {
        AbstractController controller = this;
        if (currentMode == StandByMode.EXPECTED_AMOUNT) {
            controller = getParentController();
        }
        return controller;
    }
}
