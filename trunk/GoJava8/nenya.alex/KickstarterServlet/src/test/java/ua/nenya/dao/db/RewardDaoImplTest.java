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
	private Project pro;
	private List<Reward> rewards = new ArrayList<>();

	private Reward r2;

	@Before
	public void setUp() {
		initRewards();
	}

	@After
	public void tearDown(){
		em.createQuery("DELETE FROM Reward").executeUpdate();
		em.createQuery("DELETE FROM Project").executeUpdate();
	}
	
	@Test
	public void testGetRewards() {
		List<Reward> testRewards = rewardDao.getRewards(pro.getId());
		assertNotNull(testRewards);
		assertThat(testRewards.get(0).getName(), is(rewards.get(0).getName()));
		assertThat(testRewards.get(1).getName(), is(r2.getName()));
		assertThat(testRewards.get(1).getId(), is(r2.getId()));
	}

	private void initRewards() {
		Project project = new Project();
		project.setName("project");
		pro = em.merge(project);
		
		Reward reward1 = new Reward();
		reward1.setAmount(100);
		reward1.setName("100$");
		reward1.setDescription("Reward100");
		reward1.setProject(pro);
		
		Reward reward2 = new Reward();
		reward2.setAmount(200);
		reward2.setName("200$");
		reward2.setDescription("Reward200");
		reward2.setProject(pro);

		em.merge(reward1);
		r2 = em.merge(reward2);
		
		rewards.add(reward1);
		rewards.add(reward2);
		
	}
}
