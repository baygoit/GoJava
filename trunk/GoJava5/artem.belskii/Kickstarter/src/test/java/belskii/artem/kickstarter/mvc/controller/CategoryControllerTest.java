package belskii.artem.kickstarter.mvc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import belskii.artem.kickstarter.dao.category.Category;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;

public class CategoryControllerTest {
	private CategoryController category;
	private ArrayList<Category> categoryesforEquals;

	@Before
	public void setUp() throws Exception {
		category = new CategoryController(new CategoryModel(), new CategoryView());
		categoryesforEquals = new ArrayList<Category>();
		categoryesforEquals.add(new Category(1, "Art"));
		categoryesforEquals.add(new Category(2, "Comics"));
		categoryesforEquals.add(new Category(3, "Crafts"));
		categoryesforEquals.add(new Category(4, "Dance"));
		categoryesforEquals.add(new Category(5, "Design"));
		categoryesforEquals.add(new Category(6, "Fashion"));
		categoryesforEquals.add(new Category(7, "Film & Video"));
		categoryesforEquals.add(new Category(8, "Food"));
		categoryesforEquals.add(new Category(9, "Games"));
		categoryesforEquals.add(new Category(10, "Journalism"));
		categoryesforEquals.add(new Category(11, "Music"));
		categoryesforEquals.add(new Category(12, "Photography"));
		categoryesforEquals.add(new Category(13, "Publishing"));
		categoryesforEquals.add(new Category(14, "Technology"));
		categoryesforEquals.add(new Category(15, "Theater"));
	}

	@Test
	public void testCategoryController() {
		assertNotNull(category);
	}

	@Test
	public void testAddCategory() {
		category.addCategory("Category testAddCategory");
		assertEquals("Category testAddCategory", category.getCategoryList().get(15));
		
	}

	@Test
	public void testGetCategoryList() {
		boolean answer=true;
		for (int i=0; i<category.getCategoryList().size(); i++){
			if (!category.getCategoryList().get(i).equals(categoryesforEquals.get(i).getCategoryName())){
				answer=false;
			}
		}
		assertTrue(answer);	
	}

	@Test
	public void testPrintCategoryList() {
		boolean answer=true;
		for (int i=0; i<category.printCategoryList().size(); i++){
			if (!category.printCategoryList().get(i).equals(categoryesforEquals.get(i).getCategoryName())){
				answer=false;
			}
		}
		assertTrue(answer);		
	}

}
