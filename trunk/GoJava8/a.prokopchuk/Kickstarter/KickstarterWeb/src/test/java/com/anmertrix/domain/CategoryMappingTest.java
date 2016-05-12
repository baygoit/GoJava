package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
public class CategoryMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Category c;

	@Before
	public void setUp() {
		Category category1 = new Category();
		category1.setName("Category1");
		
		Category category2 = new Category();
		category2.setName("Category2");
		em.merge(category1);
		c = em.merge(category2);
	}

	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Category").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCategoryUsage() {
		List<Category> categories = em.createQuery("FROM Category").getResultList();
		assertThat(categories.get(0).getName(), is("Category1"));
		assertThat(categories.get(0).getId(), is(1L));
		assertThat(categories.get(1).getName(), is("Category2"));
		assertThat(categories.get(1).getId(), is(2L));

		Category category = em.find(Category.class, c.getId());
		assertThat(category.getName(), is("Category2"));
		assertThat(category.getId(), is(2L));
	}
}
