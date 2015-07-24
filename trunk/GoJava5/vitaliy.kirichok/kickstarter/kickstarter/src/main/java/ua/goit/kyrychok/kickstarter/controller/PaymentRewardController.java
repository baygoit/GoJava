package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.model.Reward;

public class PaymentRewardController extends AbstractPaymentController {
    private int rewardId;

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    @Override
    protected void changeMode() {
        switch (currentMode) {
            case USER:
                currentMode = StandByMode.CARD;
                break;
            case CARD:
                currentMode = StandByMode.USER;
                break;
            default:
                throw new IndexOutOfBoundsException("Unexpected input value");
        }
    }

    @Override
    protected void addPayment(String input) {
        if (currentMode == StandByMode.CARD) {
            Reward reward = dataProvider.getReward(rewardId);
            dataProvider.incProjectBalance(projectId, reward.getAmount());
        }
    }

    @Override
    protected AbstractController returnNextController() {
        switch (currentMode) {
            case CARD:
                return getParentController();
            case USER:
                return this;
            default:
                throw new IndexOutOfBoundsException("Unexpected input value");
        }
    }
}
