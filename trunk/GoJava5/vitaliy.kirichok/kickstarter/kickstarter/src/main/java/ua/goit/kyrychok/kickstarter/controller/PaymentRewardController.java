package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.StandByMode;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.dao.RewardDao;

public class PaymentRewardController extends AbstractPaymentController {
    private int rewardId;
    private RewardDao rewardDao;

    public PaymentRewardController(ProjectDao projectDao, RewardDao rewardDao) {
        super(projectDao);
        this.rewardDao = rewardDao;
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
            incProjectBalance(projectId, rewardDao.load(rewardId).getAmount());
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
