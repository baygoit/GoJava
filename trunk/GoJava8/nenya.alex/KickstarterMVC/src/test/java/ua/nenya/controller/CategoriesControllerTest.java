package ua.nenya.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class CategoriesControllerTest {

	@Test
	public void test() {
		Map<String, Object> model = new HashMap<String, Object>();
		CategoriesController controller = new CategoriesController();
		String viewName = controller.showCategories(model);
		assertEquals("categories", viewName);
		assertThat(viewName, is("categories"));
	}

}
