package ua.goit.kyrychok.kickstarter.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.FloatValidator;
import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.view.PaymentView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractPaymentController extends BaseController {
    private static final int MAX_USER_NAME_LENGTH = 100;
    private static final Pattern cardNoPattern = Pattern.compile("^\\d{16}$");
    private PaymentView view;
    protected StandByMode currentMode;
    protected int projectId;

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setCurrentMode(StandByMode currentMode) {
        this.currentMode = currentMode;
    }

    public void setView(PaymentView view) {
        this.view = view;
    }

    private boolean isValid(String input) {
        switch (currentMode) {
            case AMOUNT:
                return isValidAmount(input);
            case CARD:
                return isValidCardNo(input);
            case USER:
                return isValidUserName(input);
            default:
                throw new IndexOutOfBoundsException("Unexpected input value");
        }
    }

    private boolean isValidUserName(String input) {
        return !(StringUtils.isBlank(input) || input.length() > MAX_USER_NAME_LENGTH);
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
        return FloatValidator.getInstance().isValid(input);
    }

    protected abstract void changeMode();

    protected abstract void updateModel(String input);

    protected abstract BaseController returnNextController();

    @Override
    public void showModel() {
        onShowModel();
        view.render(currentMode);
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            updateModel(input);
            setNextController(returnNextController());
            changeMode();
        } else {
            setNextController(this);
        }
    }
}
