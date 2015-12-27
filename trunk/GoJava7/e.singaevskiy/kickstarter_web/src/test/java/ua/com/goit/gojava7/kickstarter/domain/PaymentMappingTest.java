package ua.com.goit.gojava7.kickstarter.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PaymentMappingTest {
	
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

	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		Session session = getSession();

		Payment element1 = new Payment();
		element1.setRewardId(2);
		element1.setSum(22);
		element1.setProjectId(1);

		Payment element2 = new Payment();
		element2.setUser("U 2");
		element2.setProjectId(1);
		
		Payment element3 = new Payment();
		element3.setUser("R 3");
		element3.setSum(13);
		element3.setProjectId(3);

		session.save(element1);
		session.save(element2);
		session.save(element3);
		closeSession(session);
		
		session = getSession();
		List<Payment> list = session.createQuery("from Payment").list();
		list.forEach(System.out::println);
		closeSession(session);
		
		session = getSession();
		List<Payment> list2 = session.createQuery("from Payment where projectId = :projectId")
				.setParameter("projectId", 1).list();
		list2.forEach(System.out::println);
		closeSession(session);
	}

	private Session getSession() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}

	private void closeSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}
	
}
