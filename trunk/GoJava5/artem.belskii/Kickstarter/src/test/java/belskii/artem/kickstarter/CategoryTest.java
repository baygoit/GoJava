package belskii.artem.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTest {
	private static Category initializeCategoryFromDatabase() {
		Category category = new Category();
		category.addCategory("Art");
		category.addCategory("Comics");
		return category;
	}

	@Test
	public void testGetCategoryList() {
		Category categoryModel = initializeCategoryFromDatabase();
		CategoryView categoryView = new CategoryView();
		CategoryController category = new CategoryController(categoryModel, categoryView);
		String expectedValue="[Art, Comics]";
		assertEquals(expectedValue, category.getCategoryList().toString());
		

	}

}
