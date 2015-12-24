package ua.com.goit.gojava7.kickstarter.models;

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
			System.err.println("Initial SessionFactory creation failed." + e);
			// e.printStackTrace();
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
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Payment payment1 = new Payment();
		payment1.setUser("Nike1");
		payment1.setCard("1111222233334444");
		payment1.setAmount(100);
		payment1.setProjectId(11l);

		Payment payment2 = new Payment();
		payment2.setUser("Nike2");
		payment2.setCard("1111222233332222");
		payment2.setAmount(200);
		payment2.setProjectId(22l);

		session.save(payment1);
		session.save(payment2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get by id = 1-----");
		Payment payment = session.get(Payment.class, 1l);
		System.out.println(payment);
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get list of quotes-----");
		List<Payment> payments = (List<Payment>) session.createQuery("from Payment q").list();
		for (Payment resultPayment : payments) {
			System.out.println(resultPayment);
		}
		session.close();
	}
}
