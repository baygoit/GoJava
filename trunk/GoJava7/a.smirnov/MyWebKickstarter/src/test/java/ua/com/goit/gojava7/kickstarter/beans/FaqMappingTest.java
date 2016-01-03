package ua.com.goit.gojava7.kickstarter.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FaqMappingTest {
	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@After
	public void tearDown() throws Exception {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	@Test
	public void testBasicUsage() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Faq faq1 = new Faq();
		faq1.setProjectId(1);
		faq1.setQuestion("Hello1");
		faq1.setAnswer("Good bye1");

		Faq faq2 = new Faq();
		faq2.setProjectId(2);
		faq2.setQuestion("Hello2");
		faq2.setAnswer("Good bye2");

		session.save(faq1);
		session.save(faq2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Faq faq = (Faq) session.get(Faq.class, 2l);
		System.out.println(faq);
		session.close();
	}
}
