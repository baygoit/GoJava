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

public class ProjectMappingTest {

	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate/hibernateTest.cfg.xml").build();
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

		Category category2 = new Category();
		category2.setName("TestCategory 2");

		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100L);
		project1.setDaysToGo(1L);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);

		Project project2 = new Project();
		project2.setName("TestName2");
		project2.setDescription("TestDescription2");
		project2.setGoal(200L);
		project2.setDaysToGo(2L);
		project2.setHistory("TestHistory2");
		project2.setLink("TestLink2");
		project2.setCategory(category2);

		//session.save(category1);		
		session.save(project1);
		session.save(project2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("\n-----Get Project by id = 1-----");	
		Project project = session.get(Project.class, 1L);
		System.out.println("Project: " + project);
		
		System.out.println("\n-----Get Category by id = 1-----");	
		Category category = session.get(Category.class, 1L);
		System.out.println("Category: " + category);
	
		System.out.println("\n-----Get list of projects-----");
		List<Project> projects = (List<Project>) session.createQuery("from Project q").list();
		for (Project resultProject : projects) {
			System.out.println("Project: " + resultProject);
		}
		session.close();
	}
}
