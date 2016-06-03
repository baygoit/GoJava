package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class RewardDaoImplTest {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private RewardDao rewardDao;

	private List<Reward> rewards = new ArrayList<>();
	private Project pro;

	private Reward r2;

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
	public void testGetRewardByRewardId() {
		
		assertThat(rewardDao.getRewardByRewardId(r2.getId()), is(r2));
	}

	@Test
	public void testGetProjectByRewardId(){
		
		assertThat(rewardDao.getProjectByRewardId(r2.getId()), is(pro));
	}
	
	@Test
	public void testIsRewardExistTrue(){
		assertThat(rewardDao.isRewardExist(r2.getId()), is(true));
	}
	
	@Test
	public void testIsRewardExistFalse(){
		Reward reward3 = new Reward();
		reward3.setName("100$");
		reward3.setProject(pro);
		reward3.setId(100L);
		assertThat(rewardDao.isRewardExist(reward3.getId()), is(false));
	}
	
	private void initRewards() {
		Project project = new Project();
		project.setName("project");
		pro = em.merge(project);
		
		Reward reward1 = new Reward();
		reward1.setName("100$");
		reward1.setProject(pro);
		em.merge(reward1);
		
		Reward reward2 = new Reward();
		reward2.setName("200$");
		reward2.setProject(pro);
		r2 = em.merge(reward2);
		
		rewards.add(reward1);
		rewards.add(reward2);
	}

}
