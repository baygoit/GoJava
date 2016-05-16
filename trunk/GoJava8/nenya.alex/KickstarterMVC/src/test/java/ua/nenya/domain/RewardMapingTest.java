package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class RewardMapingTest {

	@PersistenceContext
	private EntityManager em;
	private Reward r;
	
	@Before
	public void setUp() {
		Reward reward = new Reward();
		reward.setAmount(100);
		reward.setDescription("description");
		reward.setName("reward");
		r = em.merge(reward);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Reward").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRewardUsage() {
		List<Reward> rewards = em.createQuery("FROM Reward").getResultList();
		assertThat(rewards.get(0).getName(), is("reward"));
		assertThat(rewards.get(0).getAmount(), is(100));
		assertThat(rewards.get(0).getDescription(), is("description"));

		Reward rewardTest = em.find(Reward.class, r.getId());
		assertThat(rewardTest.getName(), is("reward"));
		assertThat(rewardTest.getAmount(), is(100));
		assertThat(rewardTest.getDescription(), is("description"));
	}
}
