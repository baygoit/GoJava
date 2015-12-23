package ua.com.goit.gojava7.kickstarter.models;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.models.Reward;

import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class RewardTest {

	@Mock
	private PrintStream printSteam;

	Reward reward = new Reward();

	@Before
	public void setUp() {
		reward.setId(11l);
		reward.setAmount(10);
		reward.setReward("TestReward");
		reward.setProjectId(44l);	
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(reward.getId(), is(11l));
		assertThat(reward.getAmount(), is(10));
		assertThat(reward.getReward(), is("TestReward"));
		assertThat(reward.getProjectId(), is(44l));
	}

	@Test
	public void testToString() {
		System.out.println(reward.toString());
		verify(printSteam).println(contains("TestReward"));
		verify(printSteam).println(contains("10"));
	}
}
