package ua.com.goit.gojava7.kickstarter.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void testBasicUsage() {
		Session session = getSession();
		
		Project project1 = new Project();
		project1.setIdParentCategory(1);
		project1.setProjectName("project 1");
		project1.setProjectDescription("project 1 description");
		project1.setProjectShortDescription("project 1 short description");
		project1.setProjectCostNeed(100);
		project1.setDeadline(new Date(2016, 1, 1));
		project1.setVideoUrl("http://project1.video");
		
		Project project2 = new Project();
		project2.setIdParentCategory(2);
		project2.setProjectName("project 2");
		project2.setProjectDescription("project 2 description");
		project2.setProjectShortDescription("project 2 short description");
		project2.setProjectCostNeed(200);
		project2.setDeadline(new Date(2016, 2, 2));
		project2.setVideoUrl("http://project2.video");
		
		session.save(project1);
		session.save(project2);
		closeSession(session);
		
		session = getSession();
		List<Project> list = session.createQuery("from Project").list();
		for (Project project : list) {
			System.out.println(project);
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
