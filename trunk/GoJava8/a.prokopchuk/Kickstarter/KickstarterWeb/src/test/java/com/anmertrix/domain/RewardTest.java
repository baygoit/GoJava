package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RewardTest {
	
	Reward reward = new Reward();
	
	@Test
	public void setGetIdTest() {
		reward.setId(34L);
		assertThat(reward.getId(), is(34L));
	}
	
	@Test
	public void setGetNameTest() {
		reward.setName("test2");
		assertThat(reward.getName(), is("test2"));
	}
	
	@Test
	public void setGetAmountTest() {
		reward.setAmount(200);
		assertThat(reward.getAmount(), is(200));
	}
	
	@Test
	public void setGetDescriptionTest() {
		reward.setDescription("test description");
		assertThat(reward.getDescription(), is("test description"));
	}
	
	@Test
	public void setGetProjectTest() {
		Project project = new Project();
		reward.setProject(project);
		assertThat(reward.getProject(), is(project));
	}

}
