package modelTest;

import static org.junit.Assert.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.kickstarter.model.Category;

public class CategoryMappingTest {
	
	
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
	public void categoryMappingTest() {
		

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Category category = new Category();
			category.setId(1);
			category.setTitle("title");

			Category category2 = new Category();
			category2.setId(2);
			category2.setTitle("title2");

			session.save(category);
			session.save(category2);
			session.getTransaction().commit();
			session.close();

			
			session = sessionFactory.openSession();
			session.beginTransaction();

			System.out.println("Get by id");
			category = session.get(Category.class, 1);
			System.out.println(category);
			session.close();
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<Category> result1 = (List<Category>) session.createQuery("from Category c").list();
			for (Category aCategory : result1) {
				System.out.println(aCategory);
			}
			session.close();
			
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			System.out.println("Get by id");
			category = session.get(Category.class, 1);
			System.out.println(category);

			category.setTitle("NewTitle");

			session.getTransaction().commit();
			session.close();
			
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			System.out.println("Get by id");
			category = session.get(Category.class, 1);
			assertEquals("NewTitle", category.getTitle());
			System.out.println(category);

			session.getTransaction().commit();
			session.close();
		}
	}