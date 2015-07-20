package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.mvc.model.DonatePageModel;
import ua.goit.kyrychok.kickstarter.mvc.view.DonatePageView;

public class DonatePageController extends BaseController {
    private DonatePageModel model;
    private DonatePageView view;
    private PaymentController paymentController;

    public void setModel(DonatePageModel model) {
        this.model = model;
    }

    public void setView(DonatePageView view) {
        this.view = view;
    }

    public void setPaymentController(PaymentController paymentController) {
        this.paymentController = paymentController;
    }

    private boolean isValid(String input) {
        try {
            int inputValue = Integer.parseInt(input);
            return !(inputValue < 1 || inputValue > model.getCount() + 2);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int getAmount(int index) {
        int result = 0;
        if (index > 1) {
            result = model.getReward(index - 2).getAmount();
        }
        return result;
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            paymentController.initCurrentMode(StandByMode.USER);
            paymentController.setAmount(getAmount(Integer.parseInt(input)));
            setNextController(paymentController);
            setNeedNextImmediateExecute(true);
        }
    }

    @Override
    public void showModel() {
        int categoryIndex = getParentController().getParentController().getModelIdentifier();
        int projectIndex = getParentController().getModelIdentifier();
        model.update(categoryIndex, projectIndex);
        onShowModel();
        view.render(model);
    }
}
