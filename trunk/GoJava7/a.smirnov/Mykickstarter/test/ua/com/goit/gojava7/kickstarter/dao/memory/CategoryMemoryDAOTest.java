//package ua.com.goit.gojava7.kickstarter.dao.memory;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import ua.com.goit.gojava7.kickstarter.beans.Category;
//
//public class CategoryMemoryDAOTest {
//
//	private CategoryDaoMemoryImpl categoryMemory;
//
//	@Before
//	public void setUp() throws Exception {
//		categoryMemory = new CategoryDaoMemoryImpl();
//	}
//
//	@Test
//	public void testCategoryMemoryDAO() {
//		assertThat(categoryMemory.getSize(), is(5));
//	}
//
//	@Test
//	public void testAdd() {
//		Category category = new Category("Animals");
//		category.setUniqueID(6);
//		categoryMemory.add(category);
//
//		assertThat(categoryMemory.getSize(), is(6));
//		assertThat(categoryMemory.getAll().get(5).getCategoryName(), is("Animals"));
//	}
//
//	@Test
//	public void testRemove() {
//		Category category = new Category("Ukraine");
//		categoryMemory.add(category);
//		
//		assertThat(categoryMemory.getSize(), is(6));
//		
//		categoryMemory.remove(category);
//		assertThat(categoryMemory.getSize(), is(5));
//	}
//
//	@Test
//	public void testGetAll() {
//		assertThat(categoryMemory.getAll().size(), is(5));
//		assertThat(categoryMemory.getAll().get(0).getCategoryName(), is("Arts"));
//		assertThat(categoryMemory.getAll().get(1).getCategoryName(), is("Movie"));
//		assertThat(categoryMemory.getAll().get(2).getCategoryName(), is("Sports"));
//		assertThat(categoryMemory.getAll().get(3).getCategoryName(), is("Culture"));
//		assertThat(categoryMemory.getAll().get(4).getCategoryName(), is("Food"));
//	}
//
//	@Test
//	public void testGetSize() {
//		assertThat(categoryMemory.getAll().size(), is(5));
//	}
//}
