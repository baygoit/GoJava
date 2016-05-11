package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
public class RewardMappingTest {
	
	@PersistenceContext
	private EntityManager em;
	private Reward r;

	@Before
	public void setUp() {
		Reward reward1 = new Reward();
		reward1.setName("Reward1");
		
		Reward reward2 = new Reward();
		reward2.setName("Reward2");
		em.merge(reward1);
		r = em.merge(reward2);
	}

	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Reward").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		List<Reward> rewards = em.createQuery("FROM Reward").getResultList();
		assertThat(rewards.get(0).getName(), is("Reward1"));
		assertThat(rewards.get(0).getId(), is(1L));
		assertThat(rewards.get(1).getName(), is("Reward2"));
		assertThat(rewards.get(1).getId(), is(2L));

		Reward reward = em.find(Reward.class, r.getId());
		assertThat(reward.getName(), is("Reward2"));
		assertThat(reward.getId(), is(2L));
	}

}
