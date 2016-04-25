package ua.nenya.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class CategoryMappingTest {

	private EmbeddedDatabase db;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Before
	public void setUp() throws Exception {
//		db = new EmbeddedDatabaseBuilder()
//	    		.setType(EmbeddedDatabaseType.H2)
//	    		.addScript("/createCategory.sql")
//	    		.build();
		
	}

	@After
	public void tearDown() throws Exception {
//		db = new EmbeddedDatabaseBuilder()
//	    		.setType(EmbeddedDatabaseType.H2)
//	    		.addScript("/deleteCategory.sql")
//	    		.build();
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}


//	@Test
//	public void testBasicUsage() {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		Category category1 = new Category();
//		category1.setName("Category1");
//		Category category2 = new Category();
//		category1.setName("Category2");
//
//		session.save(category1);
//		session.save(category2);
//		session.getTransaction().commit();
//		session.close();
//
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		List<Category> categories = session.createQuery("FROM CATEGORY").list();
//		System.out.println(categories);
//		assertThat(categories.get(0).getName(), is("Category1"));
//		assertThat(categories.get(1).getName(), is("Category2"));
//		
//		Category category = session.get(Category.class, 1);
//		assertThat(category.getName(), is("Category1"));
//
//		session.close();
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//
//		category = session.get(Category.class, 1);
//
//		category.setName("Changed");
//
//		session.getTransaction().commit();
//		session.close();
//		
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//
//		category = session.get(Category.class, 1);
//		assertThat(category.getName(), is("Changed"));
//		session.getTransaction().commit();
//		session.close();
//	}
}
