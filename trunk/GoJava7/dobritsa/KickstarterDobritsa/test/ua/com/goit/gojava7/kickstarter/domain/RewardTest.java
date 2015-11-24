package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class RewardTest {

	@Test
	public void testCreateReward() {
		Reward reward = new Reward(10, "you are will be happy");	
		assertThat(reward.getAmount(), is(10));
		assertThat(reward.getReward(), is("you are will be happy"));
	}
}
