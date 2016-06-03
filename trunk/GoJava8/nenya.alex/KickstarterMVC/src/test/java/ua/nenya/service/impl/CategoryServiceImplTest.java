package ua.nenya.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.domain.Category;
import ua.nenya.service.CategoryService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class CategoryServiceImplTest {
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CategoryService categoryService;
	
	private Category music;
	private Category film;

	@Before
	public void init() {
		Category musicCategory = new Category();
		musicCategory.setName("Music");

		Category filmCategory = new Category();
		filmCategory.setName("Films");

		film = em.merge(filmCategory);
		music = em.merge(musicCategory);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Category").executeUpdate();
	}

	@Test
	public void testIsCategoryExistYes(){
		assertThat(categoryService.isCategoryExistById(music.getId()), is(true));
		assertThat(categoryService.isCategoryExistById(film.getId()), is(true));
	}

	@Test
	public void testIsCategoryExistNo(){
		assertThat(categoryService.isCategoryExistById(100L), is(false));
	}

}
