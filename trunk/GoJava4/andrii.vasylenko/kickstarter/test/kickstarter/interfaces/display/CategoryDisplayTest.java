package kickstarter.interfaces.display;

import static org.junit.Assert.*;
import kickstarter.engine.Category;

import org.junit.Test;

public class CategoryDisplayTest {

	@Test
	public void shouldCategoryName_whenGetDescription() {
		Category category = new Category("The most interesting category");
		Display<Category> display = new CategoryDisplay();
		
		String result = display.getDescription(category);

		assertEquals(result, display.getDetailedDescription(category)); 
		
		assertEquals(category.getId()+" - The most interesting category", result); 
	}

}
