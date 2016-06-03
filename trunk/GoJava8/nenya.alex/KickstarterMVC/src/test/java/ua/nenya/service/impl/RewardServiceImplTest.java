package ua.nenya.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;
import ua.nenya.service.RewardService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class RewardServiceImplTest {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private RewardService rewardService;

	private Project pro;

	private Reward reward;

	@Before
	public void setUp() {
		initRewards();
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Reward").executeUpdate();
		em.createQuery("DELETE FROM Project").executeUpdate();
	}
	
	@Test
	public void testIsRewardExistTrue(){
		assertThat(rewardService.isRewardExist(reward.getId()), is(true));
	}
	
	@Test
	public void testIsRewardExistFalse(){
		Reward reward3 = new Reward();
		reward3.setName("100$");
		reward3.setProject(pro);
		reward3.setId(100L);
		assertThat(rewardService.isRewardExist(reward3.getId()), is(false));
	}

	private void initRewards() {
		Project project = new Project();
		project.setName("project");
		pro = em.merge(project);
		
		Reward reward2 = new Reward();
		reward2.setName("200$");
		reward2.setProject(pro);
		reward = em.merge(reward2);
		
	}
}
