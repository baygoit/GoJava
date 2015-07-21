package ua.goit.kyrychok.kickstarter.mvc.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Reward;
import ua.goit.kyrychok.kickstarter.mvc.model.DonatePageModel;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class DonatePageViewTest {

    @Mock
    private DonatePageModel model;
    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderDonatePageThenPrintMenu() throws Exception {
        List<Reward> rewards = new ArrayList<>();
        rewards.add(new Reward(1000, "reward 10"));
        rewards.add(new Reward(2000, "reward 20"));
        when(model.isRewardsExists()).thenReturn(rewards.size() > 0);
        when(model.getCount()).thenReturn(rewards.size());
        when(model.getReward(0)).thenReturn(rewards.get(0));
        when(model.getReward(1)).thenReturn(rewards.get(1));

        final List<String> view = new ArrayList<>();

        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                String str = (String) arguments[0];
                view.add(str);
                return null;
            }
        }).when(output).writeLine(anyString());
        DonatePageView donatePageView = new DonatePageView();
        donatePageView.setOutput(output);

        donatePageView.render(model);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("[1]. Any amount");
        expectedResult.add("[2]. <10> reward 10");
        expectedResult.add("[3]. <20> reward 20");
        expectedResult.add(BaseView.CHOICE_MESSAGE);
        Assert.assertArrayEquals("Not expected Category rendering", expectedResult.toArray(), view.toArray());
    }
}