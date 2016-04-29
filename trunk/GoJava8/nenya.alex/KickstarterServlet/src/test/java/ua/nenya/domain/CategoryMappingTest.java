package ua.nenya.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class CategoryMappingTest {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Test
	public void testCategoryUsage() {
		int id;
		try (Session session = sessionFactory.openSession()) {
			Category category = new Category();
			category.setName("Category");

			id = (int) session.save(category);
			session.flush();
		}
		try (Session session = sessionFactory.openSession()) {
			List<Category> categories = session.createQuery("FROM Category").list();
			assertThat(categories.get(0).getName(), is("Category"));

			Category category = session.get(Category.class, id);
			assertThat(category.getName(), is("Category"));

		}
	}
}
