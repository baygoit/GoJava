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

import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class RewardTest {

	@Mock
	private PrintStream printSteam;

	Reward reward = new Reward();
	Project project = new Project();

	@Before
	public void setUp() {
		project.setProjectId(22L);
		reward.setRewardId(11L);
		reward.setAmount(10L);
		reward.setReward("TestReward");
		reward.setProject(project);
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(reward.getRewardId(), is(11L));
		assertThat(reward.getAmount(), is(10L));
		assertThat(reward.getReward(), is("TestReward"));
		assertThat(reward.getProject(), is(project));
		assertThat(reward.getProjectId(), is(22L));
	}

	@Test
	public void testToString() {
		System.out.println(reward.toString());
		verify(printSteam).println(contains("TestReward"));
		verify(printSteam).println(contains("10"));
	}
}
