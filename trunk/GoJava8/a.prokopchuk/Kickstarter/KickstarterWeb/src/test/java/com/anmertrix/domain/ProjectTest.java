package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.anmertrix.domain.Project;

public class ProjectTest {

	@Test
	public void setGetIdTest() {
		Project project = new Project();
		project.setId(4);
		assertThat(project.getId(), is(4));
	}
	
	@Test
	public void setGetNameTest() {
		Project project = new Project();
		project.setName("test");
		assertThat(project.getName(), is("test"));
	}

	@Test
	public void setGetDescriptionTest() {
		Project project = new Project();
		project.setDescription("description-test");
		assertThat(project.getDescription(), is("description-test"));
	}

	@Test
	public void setGetHistoryTest() {
		Project project = new Project();
		project.setHistory("history-test");
		assertThat(project.getHistory(), is("history-test"));
	}

	@Test
	public void setGetRequiredBudgetTest() {
		Project project = new Project();
		project.setRequiredBudget(10);
		assertThat(project.getRequiredBudget(), is(10));
	}

	@Test
	public void setGetCollectedSumTest() {
		Project project = new Project();
		project.setGatheredBudget(100);
		assertThat(project.getGatheredBudget(), is(100));
	}

	@Test
	public void setGetDaysLeftTest() {
		Project project = new Project();
		project.setDaysLeft(200);
		assertThat(project.getDaysLeft(), is(200));
	}

	@Test
	public void setGetUrlTest() {
		Project project = new Project();
		project.setUrl("qqq");
		assertThat(project.getUrl(), is("qqq"));
	}

	@Test
	public void setGetQuestionAnswerTest() {
		Project project = new Project();
		project.setQuestion("qqq");
		assertThat(project.getQuestionAnswer(), is("qqq\n"));
	}

	@Test
	public void setProjectDataTest() {
		Project project = new Project();
		project.setProjectData(1, "test1", "test2", 1, 2, 3, "test3");
		assertThat(project.getId(), is(1));
		assertThat(project.getName(), is("test1"));
		assertThat(project.getDescription(), is("test2"));
		assertThat(project.getRequiredBudget(), is(1));
		assertThat(project.getGatheredBudget(), is(2));
		assertThat(project.getDaysLeft(), is(3));
		assertThat(project.getHistory(), is("test3"));
	}

}
