package ua.nenya.dao.db;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class CategoryDaoDbImplTest {

	private static EmbeddedDatabase db;
	@Autowired
	private CategoryDao categoryDao;
	private static List<Category> categories = new ArrayList<>();
	
	@BeforeClass
	public static void setUp() {
		initCategories();
		
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/createCategory.sql")
	    		.addScript("/insertCategory.sql")
	    		.build();
	}

	@AfterClass
	public static void tearDown() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/deleteCategory.sql")
	    		.build();
	}
	
	@Test
	public void testGetCategories(){
		
		Collections.sort(categories, new Comparator<Category>() {

			@Override
			public int compare(Category o1, Category o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		List<Category> categoriesTest = categoryDao.getCategories();
		assertNotNull(categoriesTest);
		assertThat(categoriesTest.get(0).getName(), is(categories.get(0).getName()));

	}

	
	@Test
	public void testIsCategoryExistYes() throws SQLException {
		assertThat(categoryDao.isCategoryExist(1), is(true));
	}
	
	@Test
	public void testIsCategoryExistNo() throws SQLException {
		assertThat(categoryDao.isCategoryExist(3), is(false));
	}
	

	private static void initCategories() {
		Category musicCategory = new Category();
		musicCategory.setId(1);
		musicCategory.setName("Music");
		
		Category filmCategory = new Category();
		filmCategory.setId(2);
		filmCategory.setName("Films");
		categories.add(musicCategory);
		categories.add(filmCategory);
	}

}
