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
public class QuoteMappingTest {
	@PersistenceContext
	private EntityManager em;

	@Test
	public void testBasicUsage() {
		
		Quote quote1 = new Quote();
		quote1.setText("Quote 1");
		quote1.setAuthor("Author 1");

		Quote quote2 = new Quote();
		quote2.setText("Quote 2");
		quote2.setAuthor("Author 2");
		
		em.persist(quote1);
		em.persist(quote2);

		Quote quoteAnswer = em.find(Quote.class, quote1.getId());
	
		assertThat(quoteAnswer.getText(), is(quote1.getText()));
		
		Quote quote = em.find(Quote.class, quote2.getId());
		quote.setText("Changed");

		quote = em.find(Quote.class, quote2.getId());
		
		assertThat(quote.getText(), is("Changed"));
	}

}
