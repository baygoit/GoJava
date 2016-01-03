package ua.com.goit.gojava7.kickstarter.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RewardMappingTest {
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

		Reward reward1 = new Reward();
		reward1.setProjectId(1);
		reward1.setPledge(1000);
		reward1.setDescription("AAA");

		Reward reward2 = new Reward();
		reward2.setProjectId(2);
		reward2.setPledge(2000);
		reward2.setDescription("BBB");

		session.save(reward1);
		session.save(reward2);

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Reward reward = (Reward) session.get(Reward.class, 2l);
		System.out.println(reward);
		session.close();
	}
}
