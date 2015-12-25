package ua.com.goit.gojava7.kickstarter.model;

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
		
		Payment payment1 = new Payment();
		payment1.setIdParentProject(1);
		payment1.setCardOwner("owner 1");
		payment1.setCardNumber(1111111111111111L);
		payment1.setRechargeAmount(111);
		
		Payment payment2 = new Payment();
		payment2.setIdParentProject(2);
		payment2.setCardOwner("owner 2");
		payment2.setCardNumber(2222222222222222L);
		payment2.setRechargeAmount(222);
		
		session.save(payment1);
		session.save(payment2);
		closeSession(session);
		
		session = getSession();
		List<Payment> list = session.createQuery("from Payment").list();
		for (Payment payment : list) {
			System.out.println(payment);
		}
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
