package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.apache.commons.validator.routines.FloatValidator;
import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.mvc.model.PaymentModel;
import ua.goit.kyrychok.kickstarter.mvc.view.PaymentView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentController extends BaseController {
    private static final int MAX_USER_NAME_LENGTH = 100;
    private static final Pattern cardNoPattern = Pattern.compile("^\\d{16}$");
    private PaymentModel model;
    private PaymentView view;
    private StandByMode currentMode;
    private FloatValidator floatValidator = new FloatValidator();

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
        boolean result;
        String cardNo = input.replaceAll(" ", "");
        /**/
        Matcher matcher = cardNoPattern.matcher(cardNo);
        result = matcher.matches();
        /*/
        //Right validation
        CreditCardValidator validator = new CreditCardValidator();
        result = validator.isValid(cardNo);
        /**/
        return result;
    }

    private boolean isValidAmount(String input) {
        return floatValidator.isValid(input);
    }

    public void initCurrentMode(StandByMode currentMode) {
        this.currentMode = currentMode;
        setNextController(this);
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

    public void setAmount(int amount) {
        model.setAmount(amount);
    }

    private void updateModel(String input) {
        if (currentMode == StandByMode.AMOUNT) {
            setAmount(convertAmount(input));
        }
        if (currentMode == StandByMode.AMOUNT ||
                (currentMode == StandByMode.CARD && model.getAmount() > 0)) {
            int categoryIndex = getParentController().getParentController().getModelIdentifier();
            int projectIndex = getParentController().getModelIdentifier();
            model.store(categoryIndex, projectIndex);
            setNextController(getParentController());
        }
    }

    private int convertAmount(String input) {
        return (int) (floatValidator.validate(input) * 100);
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
            changeMode();
            setNeedNextImmediateExecute(true);
        }
    }

}
