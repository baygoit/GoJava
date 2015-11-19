//package ua.com.goit.gojava7.kickstarter.model;
//
//import static org.hamcrest.CoreMatchers.is;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Before;
//
//public class CategoryTest {
//	private Category category1;
//	private Category category2;
//	
//	@Before
//	public void setUp() throws Exception {
//		category1 = new Category("Football");
//		category2 = new Category("Volleybol");
//	}
//
//	@Test
//	public void testCategory() {
//		assertThat(category1.getName(), is ("Football"));
//	}
//
//
//
//	@Test
//	public void testSetName() {
//		category1.setName("Soccer");
//		assertThat(category1.getName(), is ("Soccer"));
//	}
//
//	@Test
//	public void testCompareTo() {
//		int result = category1.getName().compareTo(category2.getName());
//		assertTrue(result < 0);
//	}
//
//}
