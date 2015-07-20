package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.model.Reward;
import ua.goit.kyrychok.kickstarter.mvc.model.DonatePageModel;

import static ua.goit.kyrychok.kickstarter.Utils.getMoney;

public class DonatePageView extends BaseView {

    public void render(DonatePageModel model) {
        getOutput().writeLine("[1]. Any amount");
        if (model.isRewardsExists()) {
            Reward reward;
            for (int counter = 0; counter < model.getCount(); counter++) {
                reward = model.getReward(counter);
                getOutput().writeLine(String.format("[%s]. <%s> %s", counter + 2, getMoney(reward.getAmount()), reward.getDescription()));
            }
        }
        getOutput().writeLine(CHOICE_MESSAGE);
    }
}
