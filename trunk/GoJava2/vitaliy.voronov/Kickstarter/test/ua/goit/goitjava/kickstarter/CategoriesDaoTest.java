package ua.goit.goitjava.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.goit.goitjava.kickstarter.DB.CategoriesDAO;
import ua.goit.goitjava.kickstarter.model.Category;

public class CategoriesDaoTest {
	Category cat1 = new Category("education", 1);
	CategoriesDAO categories = new CategoriesDAO();

	@Test
	public void testGetAllCategories() {
		Category category = categories.getAllCategories().get(0);
		assertEquals(cat1.getName(), category.getName());
	}

	@Test
	public void testGetSelectCategory() {
		assertEquals(cat1.toString(), categories.getSelectCategory(1).toString());
	}

}
