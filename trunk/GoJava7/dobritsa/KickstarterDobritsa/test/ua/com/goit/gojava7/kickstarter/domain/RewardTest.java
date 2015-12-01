package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class RewardTest {

	@Mock
	private PrintStream printSteam;

	Reward reward = new Reward();

	@Before
	public void setUp() {
		reward.setAmount(10);
		reward.setReward("TestReward");
		reward.setProjectName("TestProject");
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(reward.getAmount(), is(10));
		assertThat(reward.getReward(), is("TestReward"));
		assertThat(reward.getProjectName(), is("TestProject"));
	}

	@Test
	public void testToString() {
		System.out.println(reward.toString());
		verify(printSteam).println("Amount: 10; Reward: TestReward");
	}
}
