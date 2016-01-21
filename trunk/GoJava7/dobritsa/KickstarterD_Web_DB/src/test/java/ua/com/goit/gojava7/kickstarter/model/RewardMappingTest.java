package ua.com.goit.gojava7.kickstarter.model;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:H2ApplicationContext*.xml")
@Transactional
public class RewardMappingTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	@Ignore
	public void testBasicUsage() {
		Category category1 = new Category();
		category1.setName("TestCategory 1");

		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100L);
		project1.setDaysToGo(1L);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);

		Reward reward1 = new Reward();
		reward1.setAmount(10L);
		reward1.setReward("TestReward1");
		reward1.setProject(project1);

		Reward reward2 = new Reward();
		reward2.setAmount(2L);
		reward2.setReward("TestReward2");
		reward2.setProject(project1);

		em.persist(reward1);
		em.persist(reward2);

		Long rewardId1 = reward1.getRewardId();
		Long projectId1 = project1.getProjectId();
		Long categoryId1 = category1.getCategoryId();

		System.out.println("\n-----Get by id = 1-----");
		Reward reward = em.find(Reward.class, rewardId1);
		System.out.println(reward);	
		
		System.out.println("\n-----Get Project by id = 1-----");
		Project project = em.find(Project.class, projectId1);
		System.out.println("Project: " + project);
		
		System.out.println("\n-----Get Category by id = 1-----");
		Category category = em.find(Category.class, categoryId1);
		System.out.println("Category: " + category);

//		System.out.println("\n-----Get list of rewards-----");
//		List<Reward> rewards = (List<Reward>) session.createQuery("from Reward q").list();
//		for (Reward resultReward : rewards) {
//			System.out.println(resultReward);
//		}
	}
}
