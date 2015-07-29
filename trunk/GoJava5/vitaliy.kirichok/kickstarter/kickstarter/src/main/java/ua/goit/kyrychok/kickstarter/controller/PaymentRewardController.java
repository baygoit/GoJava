package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Reward;

public class PaymentRewardController extends AbstractPaymentController {
    private int rewardId;

    public PaymentRewardController(DataProvider dataProvider) {
        super(dataProvider);
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    @Override
    protected void changeMode() {
        switch (currentMode) {
            case EXPECTED_USER_NAME:
                currentMode = StandByMode.EXPECTED_CARD_NO;
                break;
            case EXPECTED_CARD_NO:
                currentMode = StandByMode.EXPECTED_USER_NAME;
                break;
            default:
                throw new IndexOutOfBoundsException("Unexpected current mode value: ".concat(currentMode.toString()));
        }
    }

    @Override
    protected void addPayment(String input) {
        if (currentMode == StandByMode.EXPECTED_CARD_NO) {
            Reward reward = dataProvider.getReward(rewardId);
            int amount = dataProvider.getProjectBalance(projectId) + reward.getAmount();
            dataProvider.setProjectBalance(projectId, amount);
        }
    }

    @Override
    protected AbstractController returnNextController() {
        AbstractController controller = this;
        if (currentMode == StandByMode.EXPECTED_CARD_NO) {
            controller = getParentController();
        }
        return controller;
    }
}
