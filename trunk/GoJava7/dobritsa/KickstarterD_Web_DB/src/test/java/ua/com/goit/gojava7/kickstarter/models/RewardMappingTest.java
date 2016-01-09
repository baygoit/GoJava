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
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernateTest.cfg.xml")
				.build();
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

		Category category1 = new Category();
		category1.setName("TestCategory 1");

		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100l);
		project1.setDaysToGo(1l);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);

		Reward reward1 = new Reward();
		reward1.setAmount(10L);
		reward1.setReward("TestReward1");
		reward1.setProject(project1);

		Reward reward2 = new Reward();
		reward2.setAmount(2L);
		reward2.setReward("TestReward2");
		reward2.setProject(project1);

		session.save(reward1);
		session.save(reward2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("\n-----Get by id = 1-----");
		Reward reward = session.get(Reward.class, 1l);
		System.out.println(reward);	
		
		System.out.println("\n-----Get Project by id = 1-----");
		Project project = session.get(Project.class, 1l);
		System.out.println("Project: " + project);
		
		System.out.println("\n-----Get Category by id = 1-----");
		Category category = session.get(Category.class, 1l);
		System.out.println("Category: " + category);
		
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get list of rewards-----");
		List<Reward> rewards = (List<Reward>) session.createQuery("from Reward q").list();
		for (Reward resultReward : rewards) {
			System.out.println(resultReward);
		}
		session.close();
	}

}
