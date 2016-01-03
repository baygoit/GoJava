package ua.com.goit.gojava7.kickstarter.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectMappingTest {
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

		Project project = new Project();
		project.setName("Inter Milano");
		project.setShortDescription("---");
		project.setFullDescription("---");
		project.setVideoLink("---");
		project.setRequiredSum(1000);
		project.setCollectedSum(20);
		project.setDaysLeft(20);

		session.save(project);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Project showProject = (Project) session.get(Project.class, 1l);
		System.out.println(showProject);
		session.close();
	}
}
