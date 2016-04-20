package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RewardTest {
	private Reward reward = new Reward();

	@Before
	public void init() {
		reward.setAmount(100);
		reward.setName("100$");
		reward.setDescription("one");
		reward.setId(1);
		reward.setProjectId(1);
	}
	@Test
	public void testGetAll() {
		assertThat(reward.getAmount() , is(100));
		assertThat(reward.getName(), is("100$"));
		assertThat(reward.getDescription(), is("one"));
		assertThat(reward.getId() , is(1));
		assertThat(reward.getProjectId() , is(1));
	}
}
