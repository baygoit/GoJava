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

public class RewardMappingTest {

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

		Reward reward1 = new Reward();
		reward1.setAmount(10);
		reward1.setReward("TestReward1");
		reward1.setProjectId(11l);

		Reward reward2 = new Reward();
		reward2.setAmount(2);
		reward2.setReward("TestReward2");
		reward2.setProjectId(22l);

		session.save(reward1);
		session.save(reward2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get by id = 1-----");
		Reward reward = session.get(Reward.class, 1l);
		System.out.println(reward);
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get list of quotes-----");
		List<Reward> rewards = (List<Reward>) session.createQuery("from Reward q").list();
		for (Reward resultReward : rewards) {
			System.out.println(resultReward);
		}
		session.close();
	}

}
