package ua.nenya.domain;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class CategoryMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Category c1;
	
	@Before
	public void setUp() {
		Category category1 = new Category();
		category1.setName("ACategory");
		c1 = em.merge(category1);
		
		Category category2 = new Category();
		category2.setName("BCategory");
		em.merge(category2);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Category").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCategoryUsage1() {
		List<Category> categories = em.createQuery("FROM Category").getResultList();
		assertThat(categories.get(0).getName(), is("ACategory"));

		Category categoryTest = em.find(Category.class, c1.getId());
		assertThat(categoryTest.getName(), is("ACategory"));
	}
	
	@Test
	public void testCategoryUsage2() {
		List<Category> categories = em
				.createNamedQuery("Category.getCategories", Category.class).getResultList();
		assertThat(categories.size(), is(2));
		assertThat(categories.get(0).getName(), is("ACategory"));
		assertThat(categories.get(1).getName(), is("BCategory"));
	}
	
	@Test
	public void testCategoryUsage3() {
		Query query = em.createNamedQuery("Category.Count");
		query.setParameter("categoryId", c1.getId());
		long count = (long) query.getSingleResult();
		assertThat(count, is(1L));
	}
}
