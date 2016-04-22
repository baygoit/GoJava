package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.anmertrix.domain.Project;

public class ProjectTest {
	
	
	private Project project = new Project();

	@Test
	public void setGetIdTest() {
		project.setId(4);
		assertThat(project.getId(), is(4));
	}
	
	@Test
	public void setGetNameTest() {
		project.setName("test");
		assertThat(project.getName(), is("test"));
	}

	@Test
	public void setGetDescriptionTest() {
		project.setDescription("description-test");
		assertThat(project.getDescription(), is("description-test"));
	}

	@Test
	public void setGetHistoryTest() {
		project.setHistory("history-test");
		assertThat(project.getHistory(), is("history-test"));
	}

	@Test
	public void setGetRequiredBudgetTest() {
		project.setRequiredBudget(10);
		assertThat(project.getRequiredBudget(), is(10));
	}

	@Test
	public void setGetCollectedSumTest() {
		project.setGatheredBudget(100);
		assertThat(project.getGatheredBudget(), is(100L));
	}

	@Test
	public void setGetDaysLeftTest() {
		project.setDaysLeft(200);
		assertThat(project.getDaysLeft(), is(200));
	}

	@Test
	public void setGetUrlTest() {
		project.setUrl("qqq");
		assertThat(project.getUrl(), is("qqq"));
	}

	@Test
	public void setGetQuestionAnswerTest() {
		project.setQuestion("qqq");
		assertThat(project.getQuestionAnswer(), is("qqq\n"));
	}

	@Test
	public void setProjectDataTest() {
		project.setProjectData(1, "test1", "test2", 1, 2, 3, "test3");
		assertThat(project.getId(), is(1));
		assertThat(project.getName(), is("test1"));
		assertThat(project.getDescription(), is("test2"));
		assertThat(project.getRequiredBudget(), is(1));
		assertThat(project.getGatheredBudget(), is(2L));
		assertThat(project.getDaysLeft(), is(3));
		assertThat(project.getHistory(), is("test3"));
	}

}
