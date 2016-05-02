package com.anmertrix.domain;

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
		reward1.setName("test1");
		reward1.setAmount(1000);
		reward1.setDescription("AAA");

		Reward reward2 = new Reward();
		reward1.setName("test2");
		reward2.setAmount(2000);
		reward2.setDescription("BBB");

		session.save(reward1);
		session.save(reward2);

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Reward reward = (Reward) session.get(Reward.class, 1l);
		System.out.println(reward);
		session.close();
	}

}
