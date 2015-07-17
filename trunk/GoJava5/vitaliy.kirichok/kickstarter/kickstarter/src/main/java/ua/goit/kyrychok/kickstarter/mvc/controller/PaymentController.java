package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.mvc.model.PaymentModel;
import ua.goit.kyrychok.kickstarter.mvc.view.PaymentView;

public class PaymentController extends BaseController {
    private static final int MAX_USER_NAME_LENGTH = 100;
    private PaymentModel model;
    private PaymentView view;
    private StandByMode currentMode;

    public void setModel(PaymentModel model) {
        this.model = model;
    }

    public void setView(PaymentView view) {
        this.view = view;
    }

    private boolean isValid(String input) {
        boolean result = false;
        switch (currentMode) {
            case AMOUNT:
                result = isValidAmount(input);
                break;
            case CARD:
                result = isValidCardNo(input);
                break;
            case USER:
                result = isValidUserName(input);
                break;
        }
        return result;
    }

    private boolean isValidUserName(String input) {
        return !(input == null || input.length() == 0 || input.length() > MAX_USER_NAME_LENGTH);
    }

    private boolean isValidCardNo(String input) {
        return true;
    }

    private boolean isValidAmount(String input) {
        return true;
    }

    public void setCurrentMode(StandByMode currentMode) {
        this.currentMode = currentMode;
    }

    private BaseController returnNext() {
        if (currentMode == StandByMode.AMOUNT) {
            return getParentController();
        } else {
            return this;
        }
    }

    private void changeMode() {
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
        }
    }

    private void updateModel(String input) {
        if (currentMode == StandByMode.AMOUNT) {
            Integer amount = Integer.parseInt(input) * 100;
            int categoryIndex = getParentController().getParentController().getModelIdentifier();
            int projectIndex = getParentController().getModelIdentifier();
            model.store(categoryIndex, projectIndex, amount);
        }
    }

    @Override
    public void showModel() {
        onShowModel();
        view.render(currentMode.getMessage());
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            updateModel(input);
            setNextController(returnNext());
            changeMode();
            setNeedNextImmediateExecute(true);
        }
    }

}
