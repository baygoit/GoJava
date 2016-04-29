package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class RewardMapingTest {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Test
	public void testRewardUsage() {
		int id;
		try (Session session = sessionFactory.openSession()) {
			Reward reward = new Reward();
			reward.setAmount(100);
			reward.setDescription("description");
			reward.setName("reward");

			id = (int) session.save(reward);
			session.flush();
		}
		try (Session session = sessionFactory.openSession()) {
			List<Reward> rewards = session.createQuery("FROM Reward").list();
			assertThat(rewards.get(0).getName(), is("reward"));
			assertThat(rewards.get(0).getAmount(), is(100));
			assertThat(rewards.get(0).getDescription(), is("description"));

			Reward reward = session.get(Reward.class, id);
			assertThat(reward.getName(), is("reward"));
			assertThat(reward.getAmount(), is(100));
			assertThat(reward.getDescription(), is("description"));
		}
	}
}
