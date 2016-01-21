package ua.com.goit.gojava7.kickstarter.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/H2/H2ApplicationContext*.xml")
@Transactional
public class QuoteMappingTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testBasicUsage() {

		Quote quote1 = new Quote();
		quote1.setText("TestQuote 1");
		quote1.setAuthor("TestAuthor 1");

		Quote quote2 = new Quote();
		quote2.setText("TestQuote 2");
		quote2.setAuthor("TestAuthor 2");

		em.persist(quote1);
		em.persist(quote2);
		Long quoteId1 = quote1.getQuoteId();

		System.out.println("\n-----Get by id = 1-----");
		Quote quote = em.find(Quote.class, quoteId1);
		System.out.println(quote);

//		System.out.println("\n-----Get list of quotes-----");

		System.out.println("\n-----Get by id = 1, than Set text = Changed-----");
		quote = em.find(Quote.class, quoteId1);
		System.out.println(quote);
		quote.setText("Changed");

		System.out.println("\n-----Get by id = 1-----");
		quote = em.find(Quote.class, quoteId1);
		System.out.println(quote);
	}
}
