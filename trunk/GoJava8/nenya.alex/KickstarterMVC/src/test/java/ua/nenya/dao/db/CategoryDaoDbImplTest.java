package ua.nenya.dao.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class CategoryDaoDbImplTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CategoryDao categoryDao;
	
	private List<Category> categories = new ArrayList<>();
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
		categories.add(musicCategory);
		categories.add(filmCategory);
		Collections.sort(categories, new Comparator<Category>() {

			@Override
			public int compare(Category o1, Category o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Category").executeUpdate();
	}

	@Test
	public void testGetCategories() {
		List<Category> categoriesTest = categoryDao.getCategories();
		assertNotNull(categoriesTest);
		assertThat(categoriesTest.get(0).getName(), is(categories.get(0).getName()));
		assertThat(categoriesTest.get(1).getName(), is("Music"));
		assertThat(categoriesTest.get(1).getId(), is(music.getId()));
	}

	@Test
	public void testIsCategoryExistYes(){
		assertThat(categoryDao.isCategoryExist(music.getId()), is(true));
		assertThat(categoryDao.isCategoryExist(film.getId()), is(true));
	}

	@Test
	public void testIsCategoryExistNo(){
		assertThat(categoryDao.isCategoryExist(3L), is(false));
	}
}
