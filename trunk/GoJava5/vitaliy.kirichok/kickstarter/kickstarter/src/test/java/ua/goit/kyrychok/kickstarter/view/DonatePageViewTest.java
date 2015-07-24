package ua.goit.kyrychok.kickstarter.view;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.kyrychok.kickstarter.ConsoleOutput4Test;
import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static ua.goit.kyrychok.kickstarter.Utils.getMoney;

public class DonatePageViewTest {
    private ConsoleOutput4Test output = new ConsoleOutput4Test();

    @Test
    public void whenRenderDonatePageThenPrintMenu() throws Exception {
        List<Reward> rewards = new ArrayList<>();
        rewards.add(new Reward(1000, "reward 10"));
        Reward reward = new Reward(2020, "reward 20.2");
        rewards.add(reward);

        DonatePageView donatePageView = new DonatePageView(output);

        donatePageView.render(rewards);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("[1]. Any amount");
        expectedResult.add("[2]. <10> reward 10");
        expectedResult.add(format("[3]. <%s> reward 20.2", getMoney(reward.getAmount())));
        expectedResult.add(BaseView.CHOICE_MESSAGE);
        Assert.assertArrayEquals("Not expected Category rendering", expectedResult.toArray(), output.getResult().toArray());
    }
}