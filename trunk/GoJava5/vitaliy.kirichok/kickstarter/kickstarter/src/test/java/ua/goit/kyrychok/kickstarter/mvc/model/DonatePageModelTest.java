package ua.goit.kyrychok.kickstarter.mvc.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.TestDataProvider;
import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class DonatePageModelTest {
    @Mock
    private DataProvider dataProvider;

    @InjectMocks
    private DonatePageModel model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGetRewardThenReturnSameReward() throws Exception {
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        List<Reward> rewards = testDataProvider.getCategory(0).getProjects().get(0).getRewards();
        Reward expectedResult = rewards.get(0);
        int expectedCount = rewards.size();
        when(dataProvider.getRewards(anyInt(), anyInt())).thenReturn(rewards);

        model.update(anyInt(), anyInt());
        Reward result = model.getReward(0);
        int count = model.getCount();

        assertEquals("Reward must be the same as registered", expectedResult, result);
        assertEquals("Rewards count must be the same as registered", expectedCount, count);
    }
}