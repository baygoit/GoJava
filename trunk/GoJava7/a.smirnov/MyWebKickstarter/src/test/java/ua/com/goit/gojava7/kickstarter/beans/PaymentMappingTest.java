package ua.com.goit.gojava7.kickstarter.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;
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

	@Test
	public void testBasicUsage() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Payment payment1 = new Payment();
		payment1.setOwnerName("Anton");
		payment1.setCreditCardNumber(123456789);
		payment1.setPledge(100);

		Payment payment2 = new Payment();
		payment2.setOwnerName("Anna");
		payment2.setCreditCardNumber(1111111111);
		payment2.setPledge(200);

		session.save(payment1);
		session.save(payment2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Payment payment = (Payment) session.get(Payment.class, 1l);
		System.out.println(payment);
		session.close();
	}
}
