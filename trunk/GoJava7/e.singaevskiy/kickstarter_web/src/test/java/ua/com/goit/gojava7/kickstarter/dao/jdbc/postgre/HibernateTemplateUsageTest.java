package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext*.xml")
public class HibernateTemplateUsageTest {

	@Autowired
	HibernateTemplate template;

	@Test
	@Transactional
	public void testQuotes() {

		template.save(new Quote("a1", "q1"));

		List<Quote> list = template.loadAll(Quote.class);
		System.out.println(list);
	}

	@Test
	@Transactional
	public void testQuotes1() {
		template.save(new Quote("a2", "q2"));
		List<Quote> list = template.loadAll(Quote.class);
		System.out.println(list);
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HibernateTemplate template = context.getBean(HibernateTemplate.class);

		template.save(new Quote("a1", "q1"));

		List<Quote> list = template.loadAll(Quote.class);
		System.out.println(list);
		
		context.close();
	}

}
