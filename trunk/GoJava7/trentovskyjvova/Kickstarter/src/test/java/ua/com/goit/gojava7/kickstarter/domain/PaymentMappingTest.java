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
public class PaymentMappingTest {
	@PersistenceContext
	private EntityManager em;

	@Test
	public void testBasicUsage() {

		ua.com.goit.gojava7.kickstarter.domain.Category category1 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category1.setName("TestCategory 1");

		Project project1 = new Project();
		project1.setName("Project 1");
		project1.setCategory(category1);

		Payment payment1 = new Payment();
		payment1.setName("Payment 1");
		payment1.setProject(project1);

		Payment payment2 = new Payment();
		payment2.setName("Payment 2");
		payment2.setProject(project1);

		em.persist(payment1);
		em.persist(payment2);

		Payment payment = em.find(Payment.class, payment1.getId());

		assertThat(payment.getName(), is(payment1.getName()));
		assertThat(payment.getProject(), is(project1));
		assertThat(payment.getProject().getCategory(), is(category1));
	}
}
