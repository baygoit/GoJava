package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.getMoney;

public class DonatePageView extends BaseView {

    public DonatePageView(Output output) {
        super(output);
    }

    public void render(List<Reward> model) {
        writeLine("[1]. Any amount");
        if (model.size() > 0) {
            Reward reward;
            for (int counter = 0; counter < model.size(); counter++) {
                reward = model.get(counter);
                writeLine(String.format("[%s]. <%s> %s", counter + 2, getMoney(reward.getAmount()), reward.getDescription()));
            }
        }
        writeLine(CHOICE_MESSAGE);
    }
}
