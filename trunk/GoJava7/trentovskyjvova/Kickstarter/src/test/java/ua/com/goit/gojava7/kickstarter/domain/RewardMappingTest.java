package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:H2/H2ApplicationContext*.xml")
@Category(IntegrationTest.class)
@Transactional
public class RewardMappingTest {
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void testBasicUsage() {
				
		Reward reward1 = new Reward();
		reward1.setBenefit("Reward 1");
		reward1.setProjectId(1);
		
		Reward reward2 = new Reward();
		reward2.setBenefit("Reward 2");
		reward2.setProjectId(1);
		
		em.persist(reward1);
		em.persist(reward2);
		
		Reward reward = em.find(Reward.class, reward1.getId());
		
		assertThat(reward.getBenefit(), is(reward1.getBenefit()));
	}
}
