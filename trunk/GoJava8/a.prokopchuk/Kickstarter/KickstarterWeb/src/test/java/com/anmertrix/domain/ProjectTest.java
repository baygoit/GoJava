package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.anmertrix.domain.Project;

public class ProjectTest {
	
	
	private Project project = new Project();

	@Test
	public void setGetIdTest() {
		project.setId(4L);
		assertThat(project.getId(), is(4L));
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
	public void setGetGatheredBudgetTest() {
		project.setGatheredBudget(100);
		assertThat(project.getGatheredBudget(), is(100L));
	}
	
	@Test
	public void setGetFinalDateTest() {
		project.setFinalDate(new Date(111111111));
		assertThat(project.getFinalDate(), is(new Date(111111111)));
	}
	
	@Test
	public void setGetDaysLeftTest() {
		project.setDaysLeft(33);
		assertThat(project.getDaysLeft(), is(33));
	}

	@Test
	public void setGetUrlTest() {
		project.setUrl("qqq");
		assertThat(project.getUrl(), is("qqq"));
	}
	
	@Test
	public void setGetQuestionsTest() {
		List<Question> questions = new ArrayList<>();
		project.setQuestions(questions);
		assertThat(project.getQuestions(), is(questions));
	}
	
	@Test
	public void setGetPaymentsTest() {
		List<Payment> payments = new ArrayList<>();
		project.setPayments(payments);
		assertThat(project.getPayments(), is(payments));
	}
	
	@Test
	public void setGetRewardsTest() {
		List<Reward> rewards = new ArrayList<>();
		project.setRewards(rewards);
		assertThat(project.getRewards(), is(rewards));
	}

}
