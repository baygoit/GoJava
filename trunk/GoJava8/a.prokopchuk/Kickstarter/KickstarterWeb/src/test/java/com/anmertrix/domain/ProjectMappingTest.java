package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
public class ProjectMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Project project;
	private Reward reward;
	private Question question;

	@Before
	public void setUp() {
		Project project1 = new Project();
		project1.setName("Project1");
		Category category1 = new Category();
		category1.setName("category1");
		project1.setCategory(category1);
		project1.setDescription("description1");
		project1.setFinalDate(new Date(700000000));
		project1.setHistory("history1");
		project1.setRequiredBudget(100);
		project1.setUrl("url1");
		
		Project project2 = new Project();
		project2.setName("Project2");
		Category category2 = new Category();
		category2.setName("category2");
		project2.setCategory(category2);
		project2.setDescription("description2");
		project2.setFinalDate(new Date(800000000));
		project2.setHistory("history2");
		project2.setRequiredBudget(400);
		project2.setUrl("url2");
		

		Reward reward1 = new Reward();
		reward1.setName("Reward1");
		reward1.setProject(project1);
		Reward reward2 = new Reward();
		reward2.setName("Reward2");
		reward2.setProject(project2);
		
		Question question1 = new Question();
		question1.setQuestion("Question1");
		Question question2 = new Question();
		question2.setQuestion("Question2");
		
		em.merge(reward1);
		reward = em.merge(reward2);
		em.merge(question1);
		question = em.merge(question2);
		em.merge(category1);
		em.merge(category2);
		em.merge(project1);
		project = em.merge(project2);
	}

	@After
	public void tearDown() {
		//em.createQuery("DELETE FROM Project").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		List<Project> projects = em.createQuery("FROM Project").getResultList();
		assertThat(projects.get(0).getName(), is("Project1"));
		//assertThat(projects.get(0).getId(), is(1L));
		assertThat(projects.get(0).getCategory().getName(), is("category1"));
		assertThat(projects.get(0).getDescription(), is("description1"));
		assertThat(projects.get(0).getFinalDate(), is(new Date(700000000)));
		assertThat(projects.get(0).getHistory(), is("history1"));
		assertThat(projects.get(0).getRequiredBudget(), is(100));
		assertThat(projects.get(0).getUrl(), is("url1"));
		
		assertThat(projects.get(1).getName(), is("Project2"));
		//assertThat(projects.get(1).getId(), is(2L));
		assertThat(projects.get(1).getCategory().getName(), is("category2"));
		assertThat(projects.get(1).getDescription(), is("description2"));
		assertThat(projects.get(1).getFinalDate(), is(new Date(800000000)));
		assertThat(projects.get(1).getHistory(), is("history2"));
		assertThat(projects.get(1).getRequiredBudget(), is(400));
		assertThat(projects.get(1).getUrl(), is("url2"));

		Project projectTest = em.find(Project.class, project.getId());
		assertThat(projectTest.getName(), is("Project2"));
		//assertThat(projectTest.getId(), is(4L));
		Reward rewardTest = em.find(Reward.class, reward.getId());
		assertThat(rewardTest.getName(), is("Reward2"));
		
		//List<Reward> rewards = projectTest.getRewards();
		//assertThat(rewards.get(0).getName(), is("Reward2"));
		
		List<Question> questions = em.createQuery("FROM Question").getResultList();
		assertThat(questions.get(0).getQuestion(), is("Question1"));
		//assertThat(questions.get(0).getId(), is(1L));
		assertThat(questions.get(1).getQuestion(), is("Question2"));
		//assertThat(questions.get(1).getId(), is(2L));

		Question questionTest = em.find(Question.class, question.getId());
		assertThat(questionTest.getQuestion(), is("Question2"));
		//assertThat(questionTest.getId(), is(2L));
	}
	
}
