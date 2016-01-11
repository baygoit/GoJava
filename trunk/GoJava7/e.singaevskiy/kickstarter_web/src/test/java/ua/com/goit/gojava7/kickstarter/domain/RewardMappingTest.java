package ua.com.goit.gojava7.kickstarter.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
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

	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		Session session = getSession();
		Category category1 = new Category(1, "Cat1");
		Category category2 = new Category(2, "Cat2");
		
		Project project1 = new Project();
		project1.setName("Proj 1");
		project1.setAuthor("Aut 1");
		project1.setCategory(category1);
		
		Project project2 = new Project();
		project2.setName("Proj 2");
		project2.setAuthor("Aut 2");
		project2.setCategory(category2);
		
		session.save(category1);
		session.save(category2);
		session.save(project1);
		session.save(project2);

		Reward element1 = new Reward();
		element1.setDescription("R 1");
		element1.setPledgeSum(42);
		element1.setProject(project1);

		Reward element2 = new Reward();
		element2.setDescription("R 2");
		element2.setProject(project1);
		
		Reward element3 = new Reward();
		element3.setDescription("R 3");
		element3.setPledgeSum(13);
		element3.setProject(project2);

		session.save(element1);
		session.save(element2);
		session.save(element3);
		closeSession(session);
		
		session = getSession();
		List<Reward> list = session.createQuery("from Reward").list();
		list.forEach(System.out::println);
		closeSession(session);
		
		session = getSession();
		List<Reward> list2 = session.createQuery("from Reward where projectId = :projectId")
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
