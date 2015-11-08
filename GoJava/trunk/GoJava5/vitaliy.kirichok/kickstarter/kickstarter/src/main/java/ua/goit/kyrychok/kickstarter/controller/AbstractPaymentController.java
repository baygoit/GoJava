package ua.goit.kyrychok.kickstarter.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.FloatValidator;
import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.view.PaymentView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

public abstract class AbstractPaymentController extends AbstractController {
    private static final int MAX_USER_NAME_LENGTH = 100;
    private static final Pattern cardNoPattern = Pattern.compile("^\\d{16}$");
    private PaymentView view;
    protected StandByMode currentMode;
    protected int projectId;
    private ProjectDao projectDao;

    public AbstractPaymentController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setCurrentMode(StandByMode currentMode) {
        this.currentMode = currentMode;
    }

    public void setView(PaymentView view) {
        this.view = view;
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

    protected abstract void addPayment(String input);

    protected abstract AbstractController returnNextController();

    @Override
    protected boolean isValid(String input) {
        switch (currentMode) {
            case EXPECTED_AMOUNT:
                return isValidAmount(input);
            case EXPECTED_CARD_NO:
                return isValidCardNo(input);
            case EXPECTED_USER_NAME:
                return isValidUserName(input);
            default:
                throw new IndexOutOfBoundsException("Unexpected current mode value: ".concat(currentMode.toString()));
        }
    }

    @Override
    protected void updateModel() {
    }

    @Override
    protected void renderModel() {
        view.render(currentMode);
    }

    @Override
    protected void doValidControl(String input) {
        addPayment(input);
        setNextController(returnNextController());
        changeMode();
        if (getNextController() == this) {
            showModel();
        }
    }

    @Override
    protected void showError(String input) {
        String message = null;
        switch (currentMode) {
            case EXPECTED_AMOUNT:
                message = "Can't parse inputted value as decimal number";
                break;
            case EXPECTED_CARD_NO:
                message = "Card number must consist only from 16 digits";
                break;
            case EXPECTED_USER_NAME:
                message = format("User name can't be empty and length can't be great than %s symbols", MAX_USER_NAME_LENGTH);
                break;
        }
        view.writeError(message);
    }

    protected void incProjectBalance(int projectId, int amount) {
        int balance = projectDao.getBalance(projectId) + amount;
        projectDao.setBalance(projectId, balance);
    }
}
