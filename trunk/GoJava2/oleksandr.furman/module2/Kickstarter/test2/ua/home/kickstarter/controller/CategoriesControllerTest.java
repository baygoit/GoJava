package ua.home.kickstarter.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.home.kickstarter.content.Category;

public class CategoriesControllerTest {
	CategoriesController categoriesController;
	List<Category> list;
	@Before
	public void setUp() {
		categoriesController = new CategoriesController();
		list = new ArrayList<Category>();
		Category category1 = new Category();
		category1.setName("TestCategory1");
		category1.setId(1);
		Category category2 = new Category();
		category2.setName("TestCategory2");
		category2.setId(2);
		list.add(category1);
		list.add(category2);
    }
	@Test 
    public void shouldReturnCategoriesInString_whenCallGetCategoriesContent() {
		String expected = "1 - TestCategory1\n2 - TestCategory2\n";
        assertEquals(expected, categoriesController.getCategoriesContent(list));
        
    }
}
